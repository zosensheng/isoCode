package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.enums.Stp08R18CredAndDebtCountryEnum;
import com.hisun.kont.mx.enums.StpCountryJurEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchData3;
import com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2;
import com.hisun.kont.mx.msg.javabean.head00100102.Contact4;
import com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1;
import com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code;
import com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1;
import com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.msg.pacs.dic.AddressType3Choice;
import com.hisun.kont.mx.msg.pacs.dic.GenericOrganisationIdentification1;
import com.hisun.kont.mx.msg.pacs.dic.OrganisationIdentification29;
import com.hisun.kont.mx.msg.pacs.dic.Party38Choice;
import com.hisun.kont.mx.msg.pacs.dic.PartyIdentification135;
import com.hisun.kont.mx.msg.pacs.dic.PersonIdentification13;
import com.hisun.kont.mx.msg.pacs.dic.PostalAddress24;


import javax.xml.datatype.XMLGregorianCalendar;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Document053 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document053">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{}FIToFICustomerCreditTransferV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class MXPacs00800108 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08";
    public final static transient Class[] _classes = new Class[]{Pacs00800108.class};

    public Pacs00800108 pacs00800108;

    public Pacs00800108 getPacs00800108() {
        return pacs00800108;
    }

    public void setPacs00800108(Pacs00800108 pacs00800108) {
        this.pacs00800108 = pacs00800108;
    }

    /*
   报文版本
    */

    public String getNamespace() {
        return NAMESPACE;
    }

    public String getBusinessProcess() {
        return BUSINESS_PROCESS;
    }

    public int getFunctionality() {
        return FUNCTIONALITY;
    }

    public int getVariant() {
        return VARIANT;
    }

    public int getVersion() {
        return VERSION;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class[] getClasses() {
        return _classes;
    }

    @Override
    public Object getDocumentObj() {
        return this.pacs00800108;
    }



}
