package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import qc.UDeaD_Community.Bot_Discord.Main;

public class ImOutCommand implements Command {
	
	private final String HELP = "/out";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}
		if(Main.isOn) {
			event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " ne participe plus").complete();
		}else {
			event.getTextChannel().sendMessage("Le party es fermer").complete();
		}
	}

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {return;}

    @Override
    public boolean send(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event) {

    }

}
