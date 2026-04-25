

public class Explode {
    import { Script } from 'playcanvas';

/**
 * Explode - Plays an explosion visual effect, light flash, sound, and triggers camera shake.
 */
export class Explode extends Script {
    initialize() {
        // Grab references to VFX and light entities
        this.light = this.entity.findByName("PointLight");
        this.mainVfx = this.entity.particlesystem;
        this.smokeVfx = this.entity.findByName("ExplosionSmoke").particlesystem;
        this.derbisVfx = this.entity.findByName("ExplosionDebris").particlesystem;

        this.timeSinceEnabled = 0;
        this.explosionInterval = 3;

        // Trigger explosion effect every 3.1 seconds
        setInterval(() => {
            this.explode();
        }, 3100);
    }

    update(dt) {
        this.timeSinceEnabled += dt;

        if (this.timeSinceEnabled > 0.5 && this.light.enabled) {
            this.light.enabled = false;
        }
    }

    explode() {
        this.timeSinceEnabled = 0;
        this.light.enabled = true;

        this.mainVfx.reset();
        this.mainVfx.play();

        this.smokeVfx.reset();
        this.smokeVfx.play();

        this.derbisVfx.reset();
        this.derbisVfx.play();

        this.entity.sound.play('vfx');
        this.app.fire("camera:shake");
    }
}
}
