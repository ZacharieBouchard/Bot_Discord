package commands;

import java.util.Collection;
import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.core.utils.PermissionUtil;
import qc.UDeaD_Community.Bot_Discord.Main;

public class ReadyPartyCommand implements Command {
	
	private final String HELP = "/partyready";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		/*if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}*/
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peut pas").complete();
			return;
		}
		if(Main.isOn) {
			String lastmessage = event.getTextChannel().getLatestMessageId();
			event.getTextChannel().deleteMessageById(lastmessage);
			event.getTextChannel().sendMessage("Prêt/Ready??").complete();
			event.getTextChannel().sendMessage("3").queue();
			event.getTextChannel().sendMessage("2").queue();
			event.getTextChannel().sendMessage("1").queue();
		}else {
			event.getTextChannel().sendMessage("Le party n'est pas commencer").complete();
		}
	
	}

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    	
    	return;
    	}

    @Override
    public boolean send(String[] args, MessageReceivedEvent event) {
    	
        return false;
    }

    @Override
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event) {
    	
    }

}
