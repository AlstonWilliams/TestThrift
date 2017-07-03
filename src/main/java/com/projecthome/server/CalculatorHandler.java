package com.projecthome.server;

import org.apache.thrift.TException;
import shared.SharedStruct;
import tutorial.Calculator;
import tutorial.InvalidOperation;
import tutorial.Work;

public class CalculatorHandler implements Calculator.Iface{
  SharedStruct sharedStruct;

  public void ping() throws TException {

  }

  public int add(int num1, int num2) throws TException {
    return num1 + num2;
  }

  public int calculate(int logid, Work w) throws InvalidOperation, TException {
    sharedStruct = new SharedStruct();
    sharedStruct.setKey(logid);
    switch (w.getOp()) {
      case SUBTRACT:
        return w.getNum1() - w.getNum2();
      case DIVIDE:
        return w.getNum1() / w.getNum2();
    }
    return 0;
  }

  public void zip() throws TException {

  }

  public SharedStruct getStruct(int key) throws TException {
    return sharedStruct;
  }
}
