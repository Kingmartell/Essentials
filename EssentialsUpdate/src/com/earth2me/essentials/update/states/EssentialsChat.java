package com.earth2me.essentials.update.states;

import com.earth2me.essentials.update.WorkListener;
import com.earth2me.essentials.update.tasks.InstallModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class EssentialsChat extends AbstractYesNoState
{
	public EssentialsChat(final StateMap states)
	{
		super(states, EssentialsProtect.class);
	}

	@Override
	public boolean guessAnswer()
	{
		final Plugin plugin = Bukkit.getPluginManager().getPlugin("EssentialsChat");
		if (plugin != null)
		{
			setAnswer(true);
			return true;
		}
		return false;
	}

	@Override
	public void askQuestion(final Player sender)
	{
		sender.sendMessage("Do you want to install EssentialsChat? (yes/no)");
		sender.sendMessage("Short descriptive text about what EssentialsChat does.");
	}

	@Override
	public void doWork(final WorkListener listener)
	{
		if (getAnswer())
		{
			new InstallModule(listener, "EssentialsChat").start();
			return;
		}
		listener.onWorkDone();
	}
}