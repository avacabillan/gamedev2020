var Scoreboard = function(game){
    Phaser.Group.call(this, game); 
};
Scoreboard.prototype = Object.create(Phaser.Group.prototype);
Scoreboard.prototype.constructor = Scoreboard;

Scoreboard.prototype.show = function(score){
    var bmd, background, gameoverText, scoreText, highScoreText, newHighScoreText, starText;


    bmd = this.game.add.bitmapData(this.game.width, this.game.height);
    bmd.ctx.fillStyle = '#000';
    bmd.ctx.fillRect(0,0, this.game.width, this.game.height); 

    background = this.game.add.sprite(0,0, bmd);
    background.alpha = 0.5; 

    this.add(background);

    var isNewHighScore = false;
    var highscore1 = localStorage.getItem('highscore1');
    if (!highscore1 || highscore1 < score) {
        isNewHighScore = true;
        highscore1 = score;
        localStorage.setItem('highscore1', highscore1);
    }
    this.y = this.game.height; 

    gameoverText =  this.game.add.bitmapText(0, 100, 'minecraftia2', 'You Died.', 36);
    gameoverText.x = this.game.width/2 - (gameoverText.textWidth/ 2);
    this.add(gameoverText);

    scoreText = this.game.add.bitmapText(0, 200, 'minecraftia2', 'Your Score: ' + score, 24);
    scoreText.x = this.game.width / 2 - (scoreText.textWidth/ 2);
    this.add(scoreText);

    highScoreText = this.game.add.bitmapText(0, 300, 'minecraftia2', 'Your High Score: ' + highscore1, 24);
    highScoreText.x = this.game.width / 2 - (highScoreText.textWidth/ 2);
    this.add(highScoreText);

    starText = this.game.add.bitmapText(0, 350, 'minecraftia2', 'Tap to play again!', 16);
    starText.x = this.game.width / 2 - (highScoreText.textWidth/ 4);
    this.add(starText);

    if (isNewHighScore) {
        newHighScoreText = this.game.add.bitmapText(0, 100, 'minecraftia2', 'New High Score!', 16);
        newHighScoreText.tint = 0x4ebef7; //'#4ebef7'
        newHighScoreText.x = gameoverText.x + gameoverText.textWidth + 40;
        newHighScoreText.angle = 45;
        this.add(newHighScoreText);
    }
    this.game.add.tween(this).to({y:0}, 1000, Phaser.Easing.Bounce.Out, true);
    this.game.input.onDown.addOnce(this.restart, this);
};
Scoreboard.prototype.restart = function(){
    this.game.state.start('Game', true, false);
};