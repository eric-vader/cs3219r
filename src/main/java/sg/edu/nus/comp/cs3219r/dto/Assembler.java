package sg.edu.nus.comp.cs3219r.dto;

public abstract class Assembler<DT extends DataTransferObject<D>, D> {

  abstract void createDataTransferObject(D domainObject);
  abstract void updateDomainObject(DT dto);
  abstract void createDomainObject(DT dto);
  
}
