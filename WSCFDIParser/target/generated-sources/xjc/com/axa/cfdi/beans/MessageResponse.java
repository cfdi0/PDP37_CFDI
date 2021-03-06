//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.30 a las 12:50:38 PM CST 
//


package com.axa.cfdi.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Clase Java para message-response complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="message-response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errors" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="messageList" type="{http://com.axa.cfdi/schema/beans/response}message" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message-response", propOrder = {
    "errors",
    "messageList"
})
@XmlRootElement(name = "response-result")
public class MessageResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected boolean errors;
    protected List<Message> messageList;

    /**
     * Default no-arg constructor
     * 
     */
    public MessageResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public MessageResponse(final boolean errors, final List<Message> messageList) {
        this.errors = errors;
        this.messageList = messageList;
    }

    /**
     * Obtiene el valor de la propiedad errors.
     * 
     */
    public boolean isErrors() {
        return errors;
    }

    /**
     * Define el valor de la propiedad errors.
     * 
     */
    public void setErrors(boolean value) {
        this.errors = value;
    }

    /**
     * Gets the value of the messageList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessageList() {
        if (messageList == null) {
            messageList = new ArrayList<Message>();
        }
        return this.messageList;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            boolean theErrors;
            theErrors = (true?this.isErrors():false);
            strategy.appendField(locator, this, "errors", buffer, theErrors);
        }
        {
            List<Message> theMessageList;
            theMessageList = (((this.messageList!= null)&&(!this.messageList.isEmpty()))?this.getMessageList():null);
            strategy.appendField(locator, this, "messageList", buffer, theMessageList);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MessageResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MessageResponse that = ((MessageResponse) object);
        {
            boolean lhsErrors;
            lhsErrors = (true?this.isErrors():false);
            boolean rhsErrors;
            rhsErrors = (true?that.isErrors():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "errors", lhsErrors), LocatorUtils.property(thatLocator, "errors", rhsErrors), lhsErrors, rhsErrors)) {
                return false;
            }
        }
        {
            List<Message> lhsMessageList;
            lhsMessageList = (((this.messageList!= null)&&(!this.messageList.isEmpty()))?this.getMessageList():null);
            List<Message> rhsMessageList;
            rhsMessageList = (((that.messageList!= null)&&(!that.messageList.isEmpty()))?that.getMessageList():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageList", lhsMessageList), LocatorUtils.property(thatLocator, "messageList", rhsMessageList), lhsMessageList, rhsMessageList)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theErrors;
            theErrors = (true?this.isErrors():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "errors", theErrors), currentHashCode, theErrors);
        }
        {
            List<Message> theMessageList;
            theMessageList = (((this.messageList!= null)&&(!this.messageList.isEmpty()))?this.getMessageList():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageList", theMessageList), currentHashCode, theMessageList);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof MessageResponse) {
            final MessageResponse copy = ((MessageResponse) draftCopy);
            boolean sourceErrors;
            sourceErrors = (true?this.isErrors():false);
            boolean copyErrors = strategy.copy(LocatorUtils.property(locator, "errors", sourceErrors), sourceErrors);
            copy.setErrors(copyErrors);
            if ((this.messageList!= null)&&(!this.messageList.isEmpty())) {
                List<Message> sourceMessageList;
                sourceMessageList = (((this.messageList!= null)&&(!this.messageList.isEmpty()))?this.getMessageList():null);
                @SuppressWarnings("unchecked")
                List<Message> copyMessageList = ((List<Message> ) strategy.copy(LocatorUtils.property(locator, "messageList", sourceMessageList), sourceMessageList));
                copy.messageList = null;
                if (copyMessageList!= null) {
                    List<Message> uniqueMessageListl = copy.getMessageList();
                    uniqueMessageListl.addAll(copyMessageList);
                }
            } else {
                copy.messageList = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new MessageResponse();
    }

}
