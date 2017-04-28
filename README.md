# JMS
- The are two packages (one with a servlet and the other with a message consumer, who must be triggered as a java application)
- The servlet is configured as a message producer (connection factory, destination and so on) without annotations.
- The app. server uses glassfish. The jar package gf-client.jar which is in the glassfish folder must be built in eclipse, otherwise, it might be that the message consumer throws an error (does not find the queue).

