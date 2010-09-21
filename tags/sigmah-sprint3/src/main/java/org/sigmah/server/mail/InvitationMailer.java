/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.server.mail;

import com.google.inject.Inject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.sigmah.server.util.logging.LogException;
import org.sigmah.server.util.logging.Trace;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class InvitationMailer implements Mailer<Invitation> {

    private final Configuration templateCfg;
    private final MailSender sender;
    static final String TEXT_TEMPLATE = "mail/Invite.ftl";

    @Inject
    public InvitationMailer(Configuration templateCfg, MailSender sender) {
        this.templateCfg = templateCfg;
        this.sender = sender;
    }

    @Override
    @Trace
    @LogException
    public void send(Invitation model, Locale locale)
            throws EmailException, TemplateException, IOException {

        ResourceBundle mailMessages = getResourceBundle(locale);

        SimpleEmail mail = new SimpleEmail();
        mail.addTo(model.getNewUser().getEmail(), model.getNewUser().getName());
        mail.addBcc("akbertram@gmail.com"); // for testing purposes
        mail.setSubject(mailMessages.getString("newUserSubject"));

        mail.setMsg(composeMessage(model, locale));

        sender.send(mail);
    }

    private ResourceBundle getResourceBundle(Locale locale) {
        return ResourceBundle.getBundle("org.sigmah.server.mail.MailMessages", locale);
    }

    private String composeMessage(Invitation model, Locale locale)
            throws IOException, TemplateException {

        StringWriter writer = new StringWriter();
        Template template = templateCfg.getTemplate(TEXT_TEMPLATE, locale);
        template.process(model, writer);
        return writer.toString();
    }
}