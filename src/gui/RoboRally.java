package gui;

import java.util.HashMap;
import java.util.Map;

import ingame.MovementCard;

import javax.swing.JFrame;




import org.apache.log4j.PropertyConfigurator;
import org.kisst.cfg4j.Props;
import org.kisst.cfg4j.SimpleProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoboRally extends JFrame {
	private static final Logger logger = LoggerFactory.getLogger(RoboRally.class);

	Map<Integer, MovementCard> cards = new HashMap<Integer, MovementCard>();
	
	public RoboRally() {
		PropertyConfigurator.configure("config/log4j.properties");
		
		SimpleProps props = new SimpleProps();
		props.load("config/robo.properties");
		Props roboCardProps=props.getProps("robo.cards");
	
		//System.out.println(roboCardProps);
		logger.debug("props gehaald");

		int count=0;
		for (String name: roboCardProps.keys()){
			count++;
			//logger.debug(name);
			int movement = roboCardProps.getInt(name+ ".movement", 0);
			int prio = roboCardProps.getInt(name + ".prio");
			String direction = roboCardProps.getString(name + ".direction");
			
			MovementCard card = new MovementCard(direction, movement, prio);
			
			
			cards.put(count, card);
			
			
			
		}
		
		System.out.println(cards.get(1));
	}
	
	public static void main(String[] args) {
		RoboRally roboRally = new RoboRally();
		roboRally.setSize(600, 600);
		roboRally.setVisible(true);
		roboRally.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}
	
}
