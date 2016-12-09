package coffee.synyx.auth.config.integration.security.ldap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;


/**
 * @author  Tobias Schneider
 */
public class AuthLdapConfigurationPropertiesTest {

    @Test
    public void testDefaultValues() {

        AuthLdapConfigurationProperties sut = new AuthLdapConfigurationProperties();

        assertThat(sut.getUrl(), is("ldap://localhost:389"));
        assertThat(sut.getBase(), is(nullValue()));
        assertThat(sut.getUserSearchBase(), is("ou=accounts"));
        assertThat(sut.getUserSearchFilter(), is("uid={0}"));
        assertThat(sut.getGroupSearchBase(), is("ou=roles,ou=groups"));
        assertThat(sut.getGroupSearchFilter(), is("member={0}"));
        assertThat(sut.getGroupRoleAttribute(), is("cn"));
        assertThat(sut.getRolePrefix(), is("ROLE_"));
    }
}
