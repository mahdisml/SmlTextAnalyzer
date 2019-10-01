import java.io.File

class TextAnalyzer (PATH : String) {
    private val data:List<String> = File(PATH).readText().split(" ","\n","\r")
    private var words:MutableMap<String,Int> = mutableMapOf()
    init {
        for (i in data){
            if(i != "") {
                if (!words.containsKey(i.toLowerCase())) {
                    words[i.toLowerCase()] = 1
                } else {
                    words[i.toLowerCase()] = words[i.toLowerCase()]!! + 1
                }
            }
        }
        words = words.toList().sortedByDescending { (_, value) -> value }.toMap().toMutableMap()
    }
    fun print (){
        for (i in words) {
            println("${i.key} : ${i.value}")
        }
    }
}
