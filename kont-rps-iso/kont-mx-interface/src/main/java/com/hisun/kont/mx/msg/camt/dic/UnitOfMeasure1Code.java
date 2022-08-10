package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnitOfMeasure1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasure1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="PIEC"/>
 *     &lt;enumeration value="TONS"/>
 *     &lt;enumeration value="FOOT"/>
 *     &lt;enumeration value="GBGA"/>
 *     &lt;enumeration value="USGA"/>
 *     &lt;enumeration value="GRAM"/>
 *     &lt;enumeration value="INCH"/>
 *     &lt;enumeration value="KILO"/>
 *     &lt;enumeration value="PUND"/>
 *     &lt;enumeration value="METR"/>
 *     &lt;enumeration value="CMET"/>
 *     &lt;enumeration value="MMET"/>
 *     &lt;enumeration value="LITR"/>
 *     &lt;enumeration value="CELI"/>
 *     &lt;enumeration value="MILI"/>
 *     &lt;enumeration value="GBOU"/>
 *     &lt;enumeration value="USOU"/>
 *     &lt;enumeration value="GBQA"/>
 *     &lt;enumeration value="USQA"/>
 *     &lt;enumeration value="GBPI"/>
 *     &lt;enumeration value="USPI"/>
 *     &lt;enumeration value="MILE"/>
 *     &lt;enumeration value="KMET"/>
 *     &lt;enumeration value="YARD"/>
 *     &lt;enumeration value="SQKI"/>
 *     &lt;enumeration value="HECT"/>
 *     &lt;enumeration value="ARES"/>
 *     &lt;enumeration value="SMET"/>
 *     &lt;enumeration value="SCMT"/>
 *     &lt;enumeration value="SMIL"/>
 *     &lt;enumeration value="SQMI"/>
 *     &lt;enumeration value="SQYA"/>
 *     &lt;enumeration value="SQFO"/>
 *     &lt;enumeration value="SQIN"/>
 *     &lt;enumeration value="ACRE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasure1Code")
@XmlEnum
public enum UnitOfMeasure1Code {


    /**
     * Standard length of cloth, wallpaper, as an item for sale or amount of a substance.
     * 
     */
    PIEC,

    /**
     * Measure of weight, in Britain 2240lb (long ton)and in the US 2000lb (short ton).
     * 
     */
    TONS,

    /**
     * Unit of length equal to 1/3 yard.
     * 
     */
    FOOT,

    /**
     * Unit of volume that is equal to 8 pints.
     * 
     */
    GBGA,

    /**
     * Unit of volume that is equal to 8 pints.
     * 
     */
    USGA,

    /**
     * Unit of measure that is equal to a 1, 000th of a kilo.
     * 
     */
    GRAM,

    /**
     * Measure of length equal to 2.54 cm.
     * 
     */
    INCH,

    /**
     * Basic unit of mass in the SI system, 1000 grams.
     * 
     */
    KILO,

    /**
     * Unit of weight equal to 0.454 kilograms.
     * 
     */
    PUND,

    /**
     * Unit of length in the metric system, equal to 39.37 inches.
     * 
     */
    METR,

    /**
     * Unit of measure that is equal to one hundredth of a metre.
     * 
     */
    CMET,

    /**
     * Unit of measure that is a thousandth of one metre.
     * 
     */
    MMET,

    /**
     * Unit of volume that is equal to a thousand cubic centimetres.
     * 
     */
    LITR,

    /**
     * Unit of volume that is equal to one hundredth of a litre.
     * 
     */
    CELI,

    /**
     * Unit of volume that is equal to one thousandth of a litre.
     * 
     */
    MILI,

    /**
     * Unit of weight equal to a sixteenth of a pound.
     * 
     */
    GBOU,

    /**
     * Unit of weight equal to a sixteenth of a pound.
     * 
     */
    USOU,

    /**
     * Unit of volume that is equal to 2 pints.
     * 
     */
    GBQA,

    /**
     * Unit of volume that is equal to 2 pints.
     * 
     */
    USQA,

    /**
     * Unit of volume that is equal to 568 cubic centimetres.
     * 
     */
    GBPI,

    /**
     * Unit of volume that is equal to 473 cubic centimetres.
     * 
     */
    USPI,

    /**
     * Unit of length equal to 1, 760 yards.
     * 
     */
    MILE,

    /**
     * Unit of measure that is equal to 1, 000 meters.
     * 
     */
    KMET,

    /**
     * Unit of length equal to 3 feet or 0.9144 metre.
     * 
     */
    YARD,

    /**
     * Measure of a surface, one kilometre by one kilometre.
     * 
     */
    SQKI,

    /**
     * Unit of measure that is equal to 10, 000 square meters.
     * 
     */
    HECT,

    /**
     * Unit of measure equal to a 100 square meters.
     * 
     */
    ARES,

    /**
     * Measure of a surface, one metre by one metre.
     * 
     */
    SMET,

    /**
     * Measure of a surface, one centimetre by one centimetre.
     * 
     */
    SCMT,

    /**
     * Measure of a surface, one millimetre by one millimetre.
     * 
     */
    SMIL,

    /**
     * Measure of a surface, one mile by one mile.
     * 
     */
    SQMI,

    /**
     * Measure of a surface, one yard by one yard.
     * 
     */
    SQYA,

    /**
     * Measure of a surface, one foot by one foot.
     * 
     */
    SQFO,

    /**
     * Measure of a surface, one inch by one inch.
     * 
     */
    SQIN,

    /**
     * Unit of measure equal to 4, 840 square yards.
     * 
     */
    ACRE;

    public String value() {
        return name();
    }

    public static UnitOfMeasure1Code fromValue(String v) {
        return valueOf(v);
    }

}
