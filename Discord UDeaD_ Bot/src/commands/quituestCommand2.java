package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class quituestCommand2 implements Command {
	
	private final String HELP = "/youareyou";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}	
		event.getTextChannel().sendMessage("Je suis un bot créé dans le but d'améliorer le contenue sur la communauté de la UDeaD, Merci de tavoir renseigner sur moi "+ event.getAuthor().getAsMention()).queue();
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
