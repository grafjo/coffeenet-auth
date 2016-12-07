package coffee.synyx.auth.config.integration.security.ldap;

import org.springframework.ldap.core.support.AbstractTlsDirContextAuthenticationStrategy;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;


/**
 * @author  Tobias Schneider - schneider@synyx.de
 */
public class CoffeeNetDefaultTlsDirContextAuthenticationStrategy extends AbstractTlsDirContextAuthenticationStrategy {

    private static final String SIMPLE_AUTHENTICATION = "simple";

    @Override
    protected void applyAuthentication(LdapContext ctx, String userDn, String password) throws NamingException {

        ctx.addToEnvironment(Context.SECURITY_AUTHENTICATION, SIMPLE_AUTHENTICATION);
        ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, userDn);
        ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);

        // Force reconnect with user credentials
        ctx.reconnect(null);
    }
}