package Inject.Bindings;

import Inject.Implementation.ILogin;
import com.google.inject.AbstractModule;
import pages.actions.MarketPlaceActions;
import pages.modules.MarketPlace;


public class Bindings extends AbstractModule {
    @Override
    protected void configure() {
        bind(ILogin.class).to(MarketPlace.class);
    }
}
