package commands;

import java.util.List;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class pubCommand implements Command {
	
	private final String HELP = "/pub";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}
	
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		long Nbjoueur =  event.getGuild().getMemberCache().size();
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}	
		event.getTextChannel().sendMessage("╔═══════════════════╗\r\n" + 
				"        :crown: UDeaD Community :crown:\r\n" + 
				"╚═══════════════════╝\r\n" + 
				"https://discord.gg/v36Hwsd\r\n" + 
				"\r\n" + 
				"Serveur Discord avec une communautée active avec plus de "+ "''" + Nbjoueur + " MEMBRES" + "''" + "ainsi qu'un staff très réactif! Bienvenue à tous !!\r\n" + 
				"\r\n" + 
				":white_check_mark: Langues : Française et Anglaise\r\n" + 
				":white_check_mark: Avec salons Multi-Gaming\r\n" + 
				":white_check_mark: Des salons Pub !:small_blue_diamond: \r\n" + 
				":white_check_mark: Une communautée en pleine expension (+15 membres par jours!)\r\n" + 
				":white_check_mark: Un serveur en amélioration constante !\r\n" + 
				"\r\n" + 
				"Lien : https://discord.gg/v36Hwsd").queue();
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
