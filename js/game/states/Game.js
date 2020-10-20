 ZenvaRunner.Game = function(){
    this.playerMinAngle = -20; 
    this.playerMaxAngle = 20; 

    this.blaRate = 3500; 
    this.blaTimer = 0;

    this.greRate = 15000; 
    this.greTimer = 0;

    this.balRate = 3000; 
    this.balTimer = 0;
    
    this.fireRate=100;
    this.bulletTime=0;
    this.sprite =0;
    this.score = 0;
    this.kill=0;
};
ZenvaRunner.Game.prototype = {
    create: function(){
        this.background = this.game.add.tileSprite(0, 0, this.game.width, 500, 'background');
        this.foreground = this.game.add.tileSprite(0, 450, this.game.width, this.game.height -500, 'foreground');
        this.ground = this.game.add.tileSprite(0, 560, this.game.width, 155, 'ground');
        this.player = this.add.sprite(100, this.game.height/2, 'player');
        this.player.scale.setTo(0.5);

        this.sprite = game.add.sprite(155, this.game.height/2, 'arrow');
        this.sprite.scale.setTo(0.4);
        this.sprite.anchor.setTo(0.3);
 
        this.game.physics.startSystem(Phaser.Physics.ARCADE);
        this.game.physics.arcade.gravity.y = 400;

        this.game.physics.arcade.enableBody(this.ground); 
        this.ground.body.allowGravity = false; 
        this.ground.body.immovable = true; 

        this.game.physics.arcade.enableBody(this.player); 
        this.player.body.collideWorldBounds = true; 

        this.game.physics.arcade.enableBody(this.sprite); 
        this.sprite.body.collideWorldBounds = true; 
        this.sprite.body.allowRotation = false;

        

        
        this.bal1 = this.game.add.group();
        this.bal2 = this.game.add.group();
        this.bal3 = this.game.add.group();
        this.bullets = game.add.group(); 


        this.bullets.enableBody = true; 
        this.bullets.physicsBodyType = Phaser.Physics.ARCADE; 

        this.bullets.createMultiple(1, 'bullet');
        this.bullets.callAll('events.onOutOfBounds.add', 'events.onOutOfBounds', this.resetBullet, this); 
        this.bullets.setAll('checkWorldBounds', true); 

        this.scoreText = this.game.add.bitmapText(0,0, 'minecraftia2', 'Score: 0', 30); 
        this.coinSound = this.game.add.audio('coin');
        this.deathSound = this.game.add.audio('death');
        this.shotSound = this.game.add.audio('shot');
        this.gameMusic = this.game.add.audio('gameMusic');
        this.gameMusic.play('', 0, true);
        
    },
    update: function(){
       
       
        if (this.balTimer < this.game.time.now) {
            this.createBal(); 
            this.balTimer = this.game.time.now + this.balRate; 
        }
        if (this.blaTimer < this.game.time.now) {
            this.createBal2(); 
            this.blaTimer = this.game.time.now + this.blaRate; 
        }
        if (this.greTimer < this.game.time.now) {
            this.createBalo3(); 
            this.greTimer = this.game.time.now + this.greRate; 
        }
        this.sprite.rotation = this.game.physics.arcade.angleToPointer(this.sprite);
        if (this.game.input.activePointer.isDown){
            this.fireBullet();
        }
        if(this.sprite.angle<=-60){
            this.sprite.angle=-60;
        }
         if(this.sprite.angle>=0){
            this.sprite.angle=0;
        }

        
       
        this.game.physics.arcade.collide(this.player, this.ground, this.groundHit, null, this);

        this.game.physics.arcade.overlap(this.player, this.coins, this.coinHit, null, this);

        this.game.physics.arcade.overlap(this.bal1, this.bullets, this.enemyShot, null, this);

        this.game.physics.arcade.overlap(this.bal2, this.bullets, this.enemyShot2, null, this);

        this.game.physics.arcade.overlap(this.bal3, this.bullets, this.enemyShot3, null, this);

        

       
    },
    shutdown: function(){
        
        this.bal1.destroy();
        this.bal2.destroy();
        this.bal3.destroy();
        this.bullets.destroy();
        this.score = 0;
        this.kill= 0;
        this.coinTimer = 0;
        this.blaTimer = 0;
        this.balTimer = 0;
        this.greTimer = 0;
        this.bulletTime=0;
    },
    createBal: function(){
        var x = this.game.width; 
        var y = this.game.rnd.integerInRange(150, this.game.world.height - 192);
        var enemy2 = this.bal1.getFirstExists(false);
        if (!enemy2) {
            enemy2 = new Bal1(this.game, 0, 0);
            this.bal1.add(enemy2); 
        }
        enemy2.reset(x, y); 
        enemy2.revive();
    },
    createBal2: function(){
        var x = this.game.width; 
        var y = this.game.rnd.integerInRange(150, this.game.world.height - 192);

        var enemy3 = this.bal2.getFirstExists(false);
        if (!enemy3) {
            enemy3 = new Bal2(this.game, 10, 30); 
            this.bal2.add(enemy3); 
        }
        enemy3.reset(x, y); 
        enemy3.revive();
    },
    createBalo3: function(){
        var x = this.game.width; 
        var y = this.game.rnd.integerInRange(150, this.game.world.height - 192);
        var enemy4 = this.bal3.getFirstExists(false);
        if (!enemy4) {
            enemy4 = new Bal3(this.game, 50, 20);
            this.bal3.add(enemy4); 
        }
        enemy4.reset(x, y); 
        enemy4.revive();
    },
    fireBullet:function(){ 
        if (this.game.time.now > this.bulletTime){
        bullet = this.bullets.getFirstExists(false);

            if (bullet){
                bullet.reset(this.player.x + 90, this.player.y +100 ); 
                this.game.physics.arcade.moveToPointer(bullet,1400);



            }
        }
    },
    resetBullet: function(bullet){
        bullet.kill();
        this.shotSound.play();
    },
    enemyShot: function(bullet, enemy2){
        this.score+=1; 
        this.coinSound.play(); 
        bullet.kill(); 
        enemy2.kill(); 
        this.scoreText.text = 'Score: ' + this.score; 

    },
    enemyShot2: function(bullet, enemy3){
        enemy3.kill(); 
        bullet.kill();
        this.coinSound.play();
        this.deathSound.play(); 
        this.gameMusic.stop(); 
        this.bal2.setAll('body.velocity.x', 0);
        this.bal1.setAll('body.velocity.x', 0);

        this.balTimer = Number.MAX_VALUE;
        this.blaTimer = Number.MAX_VALUE; 
        this.greTimer = Number.MAX_VALUE; 
        this.scoreText.text = 'Score: ' + this.score; 
        var scoreboard = new Scoreboard(this.game);
        scoreboard.show(this.score); 
    },
    enemyShot3: function(bullet, enemy4){
        this.score+=2;
        this.coinSound.play(); 
        bullet.kill(); 
        enemy4.kill(); 
        this.scoreText.text = 'Score: ' + this.score; 
         

    }

   
};