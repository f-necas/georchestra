package org.georchestra.console.ws.editorgdetails;

import com.google.common.io.ByteStreams;
import org.apache.commons.io.IOUtils;
import org.georchestra.console.ds.AccountDao;
import org.georchestra.console.ds.OrgsDao;
import org.georchestra.console.ds.RoleDao;
import org.georchestra.console.dto.AccountFactory;
import org.georchestra.console.dto.Role;
import org.georchestra.console.dto.RoleFactory;
import org.georchestra.console.dto.orgs.Org;
import org.georchestra.console.dto.orgs.OrgExt;
import org.georchestra.console.ws.utils.Validation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditOrgDetailsFormControllerTest {
    private EditOrgDetailsFormController ctrl;
    private AccountDao accountDao = Mockito.mock(AccountDao.class);
    private OrgsDao orgsDao = Mockito.mock(OrgsDao.class);
    private RoleDao rolesDao = Mockito.mock(RoleDao.class);

    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();

    private EditOrgDetailsFormBean formBean = new EditOrgDetailsFormBean();
    private BindingResult resultErrors = Mockito.mock(BindingResult.class);

    private SessionStatus sessionStatus = Mockito.mock(SessionStatus.class);

    private Model model = Mockito.mock(Model.class);
    private Org mtesterOrg;

    @Before
    public void setUp() throws Exception {
        ctrl = new EditOrgDetailsFormController(orgsDao, accountDao, rolesDao, new Validation(""));
        formBean.setDescription("description");
        formBean.setName("geOrchestra testing LLC");
        formBean.setAddress("48 Avenue du Lac du Bourget. 73377 Le Bourget-du-Lac");
        formBean.setUrl("https://georchestra.org");
        formBean.setId("georTest");

        OrgExt orgExt = new OrgExt();
        orgExt.setOrgType("Non profit");
        orgExt.setAddress("fake address");
        orgExt.setUrl("https://georchestra.org");
        orgExt.setDescription("A test desc");
        orgExt.setId("georTest");
        Org org = new Org();
        org.setId("georTest");
        org.setName("geOrchestra testing LLC");
        org.setOrgExt(orgExt);

        Mockito.when(this.orgsDao.findByCommonName(Mockito.eq("georTest"))).thenReturn(org);
        Mockito.when(this.orgsDao.findExtById(Mockito.eq("georTest"))).thenReturn(orgExt);
        Mockito.when(this.orgsDao.findByCommonName(Mockito.eq(""))).thenReturn(null);

        Role referentRole = RoleFactory.create("REFERENT", "referent", true);
        Role superUserRole = RoleFactory.create("SUPERUSER", "superuser", true);
        Mockito.when(this.rolesDao.findByCommonName("REFERENT")).thenReturn(referentRole);
        Mockito.when(this.rolesDao.findByCommonName("SUPERUSER")).thenReturn(superUserRole);
    }

    @Test
    public void testInitForm() {
        WebDataBinder dataBinder = new WebDataBinder(null);

        ctrl.initForm(dataBinder);

        List<String> ret = Arrays.asList(dataBinder.getAllowedFields());
        assertTrue(ret.contains("id"));
    }

    @Test
    public void testSetupFormChangeUrl() {
        request.addHeader("sec-org", "georTest");
        BindingResult resultErrors = new MapBindingResult(new HashMap<>(), "errors");
        ctrl = new EditOrgDetailsFormController(orgsDao, accountDao, rolesDao,
                new Validation("firstName," + "surname,org,orgType"));
        try (InputStream is = getClass().getResourceAsStream("georchestra_logo.png")) {
            MultipartFile logo = new MockMultipartFile("image", is);
            formBean.setUrl("https://newurl.com");
            ctrl.edit(request, response, model, formBean, logo, resultErrors, sessionStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(orgsDao.findExtById("georTest").getUrl(), "https://newurl.com");
    }

    @Test
    public void testSetupFormWithImage() {
        request.addHeader("sec-org", "georTest");
        BindingResult resultErrors = new MapBindingResult(new HashMap<>(), "errors");
        ctrl = new EditOrgDetailsFormController(orgsDao, accountDao, rolesDao,
                new Validation("firstName," + "surname,org,orgType"));
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        try (InputStream image1 = getClass().getResourceAsStream("georchestra_logo.png");
                InputStream image2 = getClass().getResourceAsStream("georchestra_logo.png")) {
            OutputStream out = Base64.getMimeEncoder().wrap(encoded);
            ByteStreams.copy(image1, out);
            String base64Image = new String(encoded.toByteArray());

            MultipartFile logo = new MockMultipartFile("image", image2);
            ctrl.edit(request, response, model, formBean, logo, resultErrors, sessionStatus);

            assertEquals(orgsDao.findExtById("georTest").getLogo(), base64Image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
