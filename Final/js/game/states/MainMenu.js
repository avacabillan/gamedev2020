ZenvaRunner.MainMenu = function(){};

ZenvaRunner.MainMenu.prototype = {
    create: function(){
       
        this.background = this.game.add.tileSprite(0, 0, this.game.width, 500, 'background');
    
        this.foreground = this.game.add.tileSprite(0, 450, this.game.width, this.game.height -500, 'foreground');
        
        this.ground = this.game.add.tileSprite(0, this.game.height -60, this.game.width, 75, 'ground');
     
        this.splash = this.add.sprite(this.game.world.centerX, this.game.world.centerY, 'logo');
        this.splash.anchor.setTo(0.5);

        this.startText = this.game.add.bitmapText(0,5, 'minecraftia', 'tap to start', 45);
        
    
        this.startText.x = this.game.width / 2 - this.startText.textWidth / 2;
        this.startText.y = this.game.width / 4 + this.splash.height / 2;
    },
    update: function(){
        if (this.game.input.activePointer.justPressed()) { 
            this.game.state.start('Game'); 
        }
    }
};