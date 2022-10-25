package com.ua.sazhyn.volodymyr;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.ua.sazhyn.volodymyr.commands.*;
public class MainModule implements Module {

    @Override
    public void configure(Binder binder){
        binder.bind(IsCommand.class);
        binder.bind(NumberCommand.class);
    }
}
