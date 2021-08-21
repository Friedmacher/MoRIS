using { com.moris.bupa as bupa } from '../db/schema';
service BuPaService @(path:'/browse') {
    @readonly entity BusinessPartners as SELECT from bupa.BusinessPartners {*, bupaType.type as bupaType}
}
