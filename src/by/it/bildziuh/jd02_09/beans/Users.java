//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.18 at 12:13:58 PM MSK 
//


package by.it.bildziuh.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://beans.jd02_09.bildziuh.it.by/}Admin"/>
 *         &lt;element name="user" type="{http://beans.jd02_09.bildziuh.it.by/}TypeOfUser" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "admin",
    "user"
})
@XmlRootElement(name = "users")
public class Users {

    @XmlElement(required = true)
    protected Admin admin;
    @XmlElement(required = true)
    protected List<TypeOfUser> user;

    /**
     * Gets the value of the admin property.
     * 
     * @return
     *     possible object is
     *     {@link Admin }
     *     
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Admin }
     *     
     */
    public void setAdmin(Admin value) {
        this.admin = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeOfUser }
     * 
     * 
     */
    public List<TypeOfUser> getUser() {
        if (user == null) {
            user = new ArrayList<TypeOfUser>();
        }
        return this.user;
    }

}
