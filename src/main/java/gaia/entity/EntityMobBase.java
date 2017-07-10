package gaia.entity;

import gaia.ConfigGaia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.world.World;

public abstract class EntityMobBase extends EntityMob {

    static final String SPAWNERCLASSNAME = MobSpawnerBaseLogic.class.getName();

    public EntityMobBase(World par1World) {
		super(par1World);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if(super.attackEntityAsMob(par1Entity)) {
			if(ConfigGaia.BaseDamage) {
				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.harm.id, 2, 0));
			}
			return true;
		} else {
			return false;
		}
	}

	protected boolean isSpawnedFromSpawner() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (StackTraceElement traceE : trace) {
            if (traceE.getClassName().equals(SPAWNERCLASSNAME)) return true;
        }
        return false;
    }

	/** 
	public boolean attackEntityAsMob(Entity par1Entity) {
		if(super.attackEntityAsMob(par1Entity)) {
			if(ConfigGaia.BaseDamage) {
	            ((EntityLivingBase)par1Entity).attackEntityFrom(CustomDamageSource.pierce, 2.0F);
			}
			return true;
		} else {
			return false;
		}
	}
	**/
}
