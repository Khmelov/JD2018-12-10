package by.it.zagurskaya.project.java.beans;

public class OperationHasEntries implements Entity {
    private long id;
    private long operationId;
    private long entryId;

    public OperationHasEntries(){
    }

    public OperationHasEntries(long id, long operationId, long entryId) {
        this.id = id;
        this.operationId = operationId;
        this.entryId = entryId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    @Override
    public String toString() {
        return "OperationHasEntries{" +
                "id=" + id +
                ", operationId=" + operationId +
                ", entryId=" + entryId +
                '}';
    }
}
