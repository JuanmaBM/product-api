package org.jmb.productapi.json;

public class ApplicationDataDTO {
   public String name;
   public String version; 

   public ApplicationDataDTO(final String name, final String version) {
       this.name = name;
       this.version = version;
   }
}
