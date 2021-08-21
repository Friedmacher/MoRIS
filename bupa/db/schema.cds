using {managed, sap} from '@sap/cds/common';
namespace com.moris.bupa;

entity BusinessPartners : managed {
    key ID      : UUID @(Core.Computed : true);
    companyName : String(100);
    firstName   : String(100);
    lastName    : String(100);
    fullName    : String(100);
    bupaType    : Association to BuPaTypes;
}

entity BuPaTypes : managed {
    key ID  : UUID @(Core.Computed : true);
    type    : String(50);
    bupas   : Association to many BusinessPartners on bupas.bupaType = $self;
}