package library;

public class DocumentCD implements Resource {
    private String CDFormat;
    private String licenseType;

    public DocumentCD(String CDFormat, String licenseType) {
        this.CDFormat = CDFormat;
        this.licenseType = licenseType;
    }

    public String getCDFormat() {
        return CDFormat;
    }

    public String getLicenseType() {
        return licenseType;
    }

    @Override
    public boolean canBeLent() {
        return true;
    }

    @Override
    public boolean canBeConsulted() {
        return false;
    }
}
