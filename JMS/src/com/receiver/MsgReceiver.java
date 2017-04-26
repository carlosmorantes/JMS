package com.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MsgReceiver {

	public static void main(String[] args) {
		try{
			// get the initial context
			Context ctx = new InitialContext();

			// lookup the queue object
			Queue queue = (Queue) ctx.lookup("jms/message");

			// lookup the queue connection factory
			ConnectionFactory connFactory = (ConnectionFactory) ctx.
					lookup("jms/ConnectionFactory");

			// create a queue connection
			Connection queueConn = connFactory.createConnection();

			// create a queue session
			Session queueSession = queueConn.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// create a queue receiver
			QueueReceiver queueReceiver = (QueueReceiver) queueSession.createConsumer(queue);

			// start the connection
			queueConn.start();

			// receive a message
			TextMessage message = (TextMessage) queueReceiver.receive();

			// print the message
			System.out.println("received: " + message.getText());

			// close the queue connection
			queueConn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
