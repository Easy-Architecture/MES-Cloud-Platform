package Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.Serializable;

/**
 * @author zhaohan
 * 企业注册类
 */
@Data
@Component
public class BusinessRegistration implements Serializable {

    private static final long serialVersionUID = 6653220084570534353L;

    /**
     * 企业法人
     */
    private String enterpriseLegalPerson;

    /**
     *客服电话
     */
    private int customerPhones;

    /**
     * 企业邮箱
     */
    private String businessEmail;

    /**
     * 仓库地址
     */
    private String warehouseAddress;

    public String getEnterpriseLegalPerson() {
        return enterpriseLegalPerson;
    }

    public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
        this.enterpriseLegalPerson = enterpriseLegalPerson;
    }

    public int getCustomerPhones() {
        return customerPhones;
    }

    public void setCustomerPhones(int customerPhones) {
        this.customerPhones = customerPhones;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public File getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(File businessLicense) {
        this.businessLicense = businessLicense;
    }

    public File getAssemblyLinePhotos() {
        return assemblyLinePhotos;
    }

    public void setAssemblyLinePhotos(File assemblyLinePhotos) {
        this.assemblyLinePhotos = assemblyLinePhotos;
    }

    /**
     *真实姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private int phone;

    /**
     * 营业执照
     */
    private File businessLicense;

    /**
     * 流水线照片
     */
    private File assemblyLinePhotos;

}

