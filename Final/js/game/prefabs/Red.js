var Bal1 = function(game, x, y, key, frame){ 
    key = 'balloon';
    Phaser.Sprite.call(this, game, x, y, key, frame);

    this.scale.setTo(0.3);
    this.anchor.setTo(0.2);

    this.game.physics.arcade.enableBody(this); 
    this.body.allowGravity = false;

    this.checkWorldBounds = true;
    this.onOutOfBoundsKill = true;

    this.events.onRevived.add(this.onRevived, this);
};

Bal1.prototype = Object.create(Phaser.Sprite.prototype);
Bal1.prototype.constructor = Bal1;

Bal1.prototype.onRevived = function(){
    this.game.add.tween(this).to({y: this.y - 16}, 500, Phaser.Easing.Linear.NONE, true, 0, Infinity, true);

    this.body.velocity.x = -100;

};