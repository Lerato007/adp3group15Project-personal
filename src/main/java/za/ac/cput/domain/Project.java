/**
 * Project.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "project")
public class Project {
    @Id
//    @OneToOne(mappedBy = "project")
    private String projectId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customerId;
    private String projectName;
    private String startDate;
    private String endDate;
    private String totalCost;
    private String status;

    public Project() {}

    public Project(Builder builder) {
        this.projectId = builder.projectId;
        this.customerId = builder.customerId;
        this.projectName = builder.projectName;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.totalCost = builder.totalCost;
        this.status = builder.status;
    }

    public String getProjectId() {return projectId;}
    public Customer getCustomerId() {return customerId;}
    public String getProjectName() {return projectName;}
    public String getStartDate() {return startDate;}
    public String getEndDate() {return endDate;}
    public String getTotalCost() {return totalCost;}
    public String getStatus() {return status;}

    public static class Builder {
        private String projectId;
        private Customer customerId;
        private String projectName;
        private String startDate;
        private String endDate;
        private String totalCost;
        private String status;

        public Builder setProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setCustomerId(Customer customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setTotalCost(String totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Project.Builder copy(Project project) {
            this.projectId = project.projectId;
            this.customerId = project.customerId;
            this.projectName = project.projectName;
            this.startDate = project.startDate;
            this.endDate = project.endDate;
            this.totalCost = project.totalCost;
            this.status = project.status;
            return this;
        }

        public Project build() {return new Project(this);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(projectId, builder.projectId) && Objects.equals(customerId, builder.customerId) && Objects.equals(projectName, builder.projectName) && Objects.equals(startDate, builder.startDate) && Objects.equals(endDate, builder.endDate) && Objects.equals(totalCost, builder.totalCost) && Objects.equals(status, builder.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(projectId, customerId, projectName, startDate, endDate, totalCost, status);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "projectId='" + projectId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", projectName='" + projectName + '\'' +
                    ", startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", totalCost='" + totalCost + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
