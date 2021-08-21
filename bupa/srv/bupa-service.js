/**
 * Implementation for BuPaService defined in ./bupa-service.cds
 */
const cds = require('@sap/cds')
module.exports = function() {
    this.after('READ', 'BusinessPartners', each => {
        if(each.bupaType == "Person") {
            each.fullName = each.firstName + " " + each.lastName
        } else {
            each.fullName = each.companyName
        }
    })
}