//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:35 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00200110;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tttt.pacs00200110 package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Document_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10", "Document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tttt.pacs00200110
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link ClearingSystemIdentification2Choice1 }
     * 
     */
    public ClearingSystemIdentification2Choice1 createClearingSystemIdentification2Choice1() {
        return new ClearingSystemIdentification2Choice1();
    }

    /**
     * Create an instance of {@link PaymentTransaction1101 }
     * 
     */
    public PaymentTransaction1101 createPaymentTransaction1101() {
        return new PaymentTransaction1101();
    }

    /**
     * Create an instance of {@link PostalAddress241 }
     * 
     */
    public PostalAddress241 createPostalAddress241() {
        return new PostalAddress241();
    }

    /**
     * Create an instance of {@link PartyIdentification1351 }
     * 
     */
    public PartyIdentification1351 createPartyIdentification1351() {
        return new PartyIdentification1351();
    }

    /**
     * Create an instance of {@link GroupHeader911 }
     * 
     */
    public GroupHeader911 createGroupHeader911() {
        return new GroupHeader911();
    }

    /**
     * Create an instance of {@link StatusReason6Choice1 }
     * 
     */
    public StatusReason6Choice1 createStatusReason6Choice1() {
        return new StatusReason6Choice1();
    }

    /**
     * Create an instance of {@link Party38Choice1 }
     * 
     */
    public Party38Choice1 createParty38Choice1() {
        return new Party38Choice1();
    }

    /**
     * Create an instance of {@link BranchAndFinancialInstitutionIdentification61 }
     * 
     */
    public BranchAndFinancialInstitutionIdentification61 createBranchAndFinancialInstitutionIdentification61() {
        return new BranchAndFinancialInstitutionIdentification61();
    }

    /**
     * Create an instance of {@link FinancialInstitutionIdentification181 }
     * 
     */
    public FinancialInstitutionIdentification181 createFinancialInstitutionIdentification181() {
        return new FinancialInstitutionIdentification181();
    }

    /**
     * Create an instance of {@link ClearingSystemMemberIdentification21 }
     * 
     */
    public ClearingSystemMemberIdentification21 createClearingSystemMemberIdentification21() {
        return new ClearingSystemMemberIdentification21();
    }

    /**
     * Create an instance of {@link OrganisationIdentification291 }
     * 
     */
    public OrganisationIdentification291 createOrganisationIdentification291() {
        return new OrganisationIdentification291();
    }

    /**
     * Create an instance of {@link PersonIdentification131 }
     * 
     */
    public PersonIdentification131 createPersonIdentification131() {
        return new PersonIdentification131();
    }

    /**
     * Create an instance of {@link StatusReasonInformation121 }
     * 
     */
    public StatusReasonInformation121 createStatusReasonInformation121() {
        return new StatusReasonInformation121();
    }

    /**
     * Create an instance of {@link GenericOrganisationIdentification11 }
     * 
     */
    public GenericOrganisationIdentification11 createGenericOrganisationIdentification11() {
        return new GenericOrganisationIdentification11();
    }

    /**
     * Create an instance of {@link OrganisationIdentificationSchemeName1Choice1 }
     * 
     */
    public OrganisationIdentificationSchemeName1Choice1 createOrganisationIdentificationSchemeName1Choice1() {
        return new OrganisationIdentificationSchemeName1Choice1();
    }

    /**
     * Create an instance of {@link PersonIdentificationSchemeName1Choice1 }
     * 
     */
    public PersonIdentificationSchemeName1Choice1 createPersonIdentificationSchemeName1Choice1() {
        return new PersonIdentificationSchemeName1Choice1();
    }

    /**
     * Create an instance of {@link GenericPersonIdentification11 }
     * 
     */
    public GenericPersonIdentification11 createGenericPersonIdentification11() {
        return new GenericPersonIdentification11();
    }

    /**
     * Create an instance of {@link DateAndPlaceOfBirth11 }
     * 
     */
    public DateAndPlaceOfBirth11 createDateAndPlaceOfBirth11() {
        return new DateAndPlaceOfBirth11();
    }

    /**
     * Create an instance of {@link OriginalGroupInformation291 }
     * 
     */
    public OriginalGroupInformation291 createOriginalGroupInformation291() {
        return new OriginalGroupInformation291();
    }

    /**
     * Create an instance of {@link FIToFIPaymentStatusReportV10 }
     * 
     */
    public FIToFIPaymentStatusReportV10 createFIToFIPaymentStatusReportV10() {
        return new FIToFIPaymentStatusReportV10();
    }

    /**
     * Create an instance of {@link DateAndDateTime2Choice1 }
     * 
     */
    public DateAndDateTime2Choice1 createDateAndDateTime2Choice1() {
        return new DateAndDateTime2Choice1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(name = "Document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

}
