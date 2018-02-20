package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;
import qc.UDeaD_Community.Bot_Discord.Main;

public class ClosePartyCommand implements Command {
	
	private final String HELP = "/closeparty";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peut pas").complete();
			return;
		}
			event.getTextChannel().sendMessage("Le Party est fermer").complete();
			Main.isOn = false;
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
