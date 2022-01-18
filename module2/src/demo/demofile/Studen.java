package demo.demofile;

public class Studen {
    private String studenId;
    private String studenName;
    private String studenPhone;
    private String studenEmail;
    public int gradePoint;

    public Studen() {

    }
    /**
     * @param studenId
     * @param studenName
     * @param studenPhone
     * @param studenEmail
     * @param gradePoint
     */
    public Studen(String studenId, String studenName, String studenPhone, String studenEmail, int gradePoint) {
        super();
        this.studenId = studenId;
        this.studenName = studenName;
        this.studenPhone = studenPhone;
        this.studenEmail = studenEmail;
        this.gradePoint = gradePoint;
    }

    /**
     * @return the studenId
     */
    public String getStudenId() {
        return studenId;
    }
    /**
     * @param studenId the studenId to set
     */
    public void setStudenId(String studenId) {
        this.studenId = studenId;
    }
    /**
     * @return the studenName
     */
    public String getStudenName() {
        return studenName;
    }
    /**
     * @param studenName the studenName to set
     */
    public void setStudenName(String studenName) {
        this.studenName = studenName;
    }
    /**
     * @return the studenPhone
     */
    public String getStudenPhone() {
        return studenPhone;
    }
    /**
     * @param studenPhone the studenPhone to set
     */
    public void setStudenPhone(String studenPhone) {
        this.studenPhone = studenPhone;
    }
    /**
     * @return the studenEmail
     */
    public String getStudenEmail() {
        return studenEmail;
    }
    /**
     * @param studenEmail the studenEmail to set
     */
    public void setStudenEmail(String studenEmail) {
        this.studenEmail = studenEmail;
    }

    /**
     * @return the gradePoint
     */
    public int getGradePoint() {
        return gradePoint;
    }

    /**
     * @param gradePoint the gradePoint to set
     */
    public void setGradePoint(int gradePoint) {
        this.gradePoint = gradePoint;
    }

    @Override
    public String toString() {
        return "Studen [studenId=" + studenId + ", studenName=" + studenName + ", studenPhone=" + studenPhone
                + ", studenEmail=" + studenEmail + ", gradePoint=" + gradePoint + "]";
    }
}
