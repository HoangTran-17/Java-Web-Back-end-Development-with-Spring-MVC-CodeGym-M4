package codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transferID;
    private int senderID;
    private String senderName;
    private int recipientID;
    private String recipientName;
    private Double transferAmount;
    private int fees;
    private Double feesAmount;


    public Transfer(int transferID, int senderID, String senderName, int recipientID,
                    String recipientName, Double transferAmount, int fees, Double feesAmount) {

        this.transferID = transferID;
        this.senderID = senderID;
        this.senderName = senderName;
        this.recipientID = recipientID;
        this.recipientName = recipientName;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
    }

    public Transfer() {

    }

    public int getTransferID() {
        return transferID;
    }

    public void setTransferID(int transferID) {
        this.transferID = transferID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public Double getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(Double feesAmount) {
        this.feesAmount = feesAmount;
    }
}
