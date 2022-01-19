package Inlämningsuppgift2


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)
Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"
För att bli godkänd på uppgiften måste du använda rekursion.
 */


class Tomteland {
    var map = mutableMapOf("Tomten" to listOf("Glader","Butter"),
         "Glader" to listOf("Trötter","Blyger", "Tröger"),
         "Butter" to listOf("Rådjuret","Nyckelpigan","Haren","Räven"),
         "Trötter" to listOf("Skumtomten"),
         "Skumtomten" to listOf("Dammråttan"),
         "Räven" to listOf("Gråsuggan", "Myran"),
         "Myran" to listOf("Bladlusen"))

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        fun inner(checkMe : MutableList<String>, res : MutableList<String>) : List<String>{
            for (i in 0 until checkMe.size){
                if ( !map[checkMe[i]].isNullOrEmpty() &&!res.contains(map[checkMe[i]]?.get(0))){
                    res.addAll(map[checkMe[i]]!!)
                    checkMe.addAll(map[checkMe[i]]!!)
                    return inner(checkMe,res)
                }
            }
            return res
        }
        val checkMe = mutableListOf(currentName)
        return inner(checkMe,res)
    }

}
fun main() {

    val tomteland = Tomteland()
    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Gladers underlydande
    //listan fylls på successivt när vi rekurserar

    val list: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlings("Glader", list))
    println()

}

// return if ( map[currentName].isNullOrEmpty()) res
// else{
//     res.add(map[currentName]!![0])
//     for (i in 0 until map[currentName]!!.size){
//         if (res.contains(map[currentName]!![i])) {
//             val sendUnderling = map[currentName]!![0]
//             map.remove(currentName)
//             return getUnderlings(sendUnderling, res)
//         }
//     }
//     return getUnderlings(res[res.size], res)
// }



//var map = mutableMapOf("Tomten" to listOf("Glader","Butter"),
//    "Glader" to listOf("Trötter","Blyger", "Tröger"),
//    "Butter" to listOf("Rådjuret","Nyckelpigan","Haren","Räven"),
//    "Trötter" to listOf("Skumtomten"),
//    "Skumtomten" to listOf("Dammråttan"),
//    "Räven" to listOf("Gråsuggan", "Myran"),
//    "Myran" to listOf("Bladlusen"))
//
//
//fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
//    res.add(currentName)
//    fun inner(res : MutableList<String>): List<String>{
//        var foundAll = false
//        for (i in 0 until res.size)
//            if(!map[res[res.size-1]].isNullOrEmpty()){
//                res.addAll(map[res[res.size-1]]!!)
//            }
//        return inner(res)
//    }
//    inner(res)
//    return res
//}