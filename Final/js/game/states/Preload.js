ZenvaRunner.Preload = function(){
    this.ready = false;
};

ZenvaRunner.Preload.prototype = {
    preload: function(){

        this.splash = this.add.sprite(this.game.world.centerX, this.game.world.centerY, 'logo');
        this.splash.anchor.setTo(0.5);

        this.preloadBar = this.add.sprite(this.game.world.centerX, this.game.world.centerY + 170, 'preloadbar');
        this.preloadBar.anchor.setTo(0.5);


        this.load.setPreloadSprite(this.preloadBar);

        this.load.image('ground', 'assets/images/grounds.png');
        this.load.image('background', 'assets/images/background1.png');
        this.load.image('foreground', 'assets/images/foreground.png');
        this.load.image('bullet', 'assets/images/pana.png');
        this.load.image('arrow', 'assets/images/arrow-01.png');
        this.load.image('player', 'assets/images/BODY-01.png',229,280,4);

        this.load.spritesheet('balloon', 'assets/images/red.png', 361, 400, 4);
        this.load.spritesheet('balloon2', 'assets/images/black.png', 361, 400, 4);
        this.load.spritesheet('balloon3', 'assets/images/green.png', 361, 400, 4);
        

        this.load.audio('gameMusic', 'assets/audio/ingame.mp3');
        this.load.audio('coin', 'assets/audio/pop.mp3');
        this.load.audio('death', 'assets/audio/death1.mp3');
        this.load.audio('shot', 'assets/audio/archery.mp3');

        this.load.bitmapFont('minecraftia', 'assets/fonts/minecraftia/font.png', 'assets/fonts/minecraftia/font.fnt');
        this.load.bitmapFont('minecraftia2', 'assets/fonts/minecraftia/minecraftia.png', 'assets/fonts/minecraftia/minecraftia.xml');
        this.load.onLoadComplete.add(this.onLoadComplete, this);
    },
    create: function(){
        this.preloadBar.cropEnabled = false;
    },
    update: function(){
        if (this.cache.isSoundDecoded('gameMusic') && this.ready === true) {
            this.state.start('MainMenu');
        }
    },
    onLoadComplete: function(){
        this.ready = true;
    }
};