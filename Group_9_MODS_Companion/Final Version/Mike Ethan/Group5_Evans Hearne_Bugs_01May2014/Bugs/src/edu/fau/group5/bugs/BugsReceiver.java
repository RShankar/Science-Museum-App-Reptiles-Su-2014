package edu.fau.group5.bugs;

import edu.fau.mods.modsapp.MODSIntents;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BugsReceiver extends BroadcastReceiver {
	public BugsReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent i = new Intent(context, MainActivity.class);
		
		if (intent.getAction().equals(MODSIntents.AFRICAN_FLAT_ROCK_SCORPION)) {
			i.putExtra("position", 0);
		} else if (intent.getAction().equals(MODSIntents.ASIAN_FOREST_SCORPION)) {
			i.putExtra("position", 1);
		} else if (intent.getAction().equals(MODSIntents.EMPEROR_SCORPION)) {
			i.putExtra("position", 2);
		} else if (intent.getAction().equals(MODSIntents.TAILLESS_WHIP_SCORPION)) {
			i.putExtra("position", 3);
		} else if (intent.getAction().equals(MODSIntents.RED_CLAW_SCORPION)) {
			i.putExtra("position", 4);
		} else if (intent.getAction().equals(MODSIntents.MADAGASCAR_HISSING_COCKROACH)) {
			i.putExtra("position", 5);
		} else if (intent.getAction().equals(MODSIntents.MEXICAN_RED_KNEE_TARANTULA)) {
			i.putExtra("position", 6);
		} else if (intent.getAction().equals(MODSIntents.MEXICAN_BLOND_TARANTULA)) {
			i.putExtra("position", 7);
		} else if (intent.getAction().equals(MODSIntents.PINK_TOE_TARANTULA)) {
			i.putExtra("position", 8);
		} else if (intent.getAction().equals(MODSIntents.ROSE_HAIRED_TARANTULA)) {
			i.putExtra("position", 9);
		} else if (intent.getAction().equals(MODSIntents.FLORIDA_IVORY_MILLIPEDE)) {
			i.putExtra("position", 10);
		}
		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}
}