package com.projecthome.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import tutorial.Calculator;

public class JavaServer {

  public static CalculatorHandler handler;

  public static Calculator.Processor processor;

  public static void main(String[] args) {
    try {
      handler = new CalculatorHandler();
      processor = new Calculator.Processor(handler);

      final Runnable simple = new Runnable() {
        @Override
        public void run() {
          simple(processor);
        }
      };

      new Thread(simple).start();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public static void simple(Calculator.Processor processor) {
    try{
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server");
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }

}
