package qc.UDeaD_Community.Bot_Discord;

import java.util.HashMap;

import javax.security.auth.login.LoginException;

import commands.ClosePartyCommand;
import commands.Command;
import commands.HelpCommand;
import commands.ImOutCommand;
import commands.ReadyPartyCommand;
import commands.StartpartyCommand;
import commands.UDeaDCommand;
import commands.pubCommand;
import commands.quituestCommand2;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.CommandParser;

public class Main {
    public static JDA jda;
    public static HashMap<String, Command> commands = new HashMap<String, Command>();
    public static final CommandParser parser = new CommandParser();
    
    public static boolean isOn = false;
    public static int count = 0;
    private static String Emojie = "✅";
	public static void main(String[] args) {
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken("NDE0OTIzNjY2Mzg4ODExNzc4.DWuc3Q.Xz0lQN3caqKYT20erPlV9Bi-dsc").buildAsync();
			jda.setAutoReconnect(true);
			jda.addEventListener(new BotListener());
			jda.addEventListener(new Botlistener2());
			System.out.println("Bot UDeaD: ON and connected");
		} catch (LoginException e) {
			e.printStackTrace();
		}
		
		commands.put("help", new HelpCommand());
		commands.put("pub", new pubCommand());
		commands.put("youareyou", new quituestCommand2());
		commands.put("udead", new UDeaDCommand());
		commands.put("out", new ImOutCommand());
		commands.put("startparty", new StartpartyCommand());
		commands.put("closeparty", new ClosePartyCommand());
		commands.put("partyready", new ReadyPartyCommand());
	}
	
    public static void handleCommand(CommandParser.CommandContainer cmd){
        if(commands.containsKey(cmd.invoke)){
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }else {
                commands.get(cmd.invoke).executed(safe, cmd.event);

            }
        }

    }

    
}
