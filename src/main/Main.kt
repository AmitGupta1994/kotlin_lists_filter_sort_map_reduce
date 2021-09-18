package main


lateinit var companyList: MutableList<Company>

fun main(args: Array<String>) {
    println("Filter Sort Map Reduce in Kotlin")

    companyList = mutableListOf()

    companyList.add(Company("C1", "Technology", startYear = 1995, endYear = null))
    companyList.add(Company("C2", "Finance", startYear = 1994, endYear = 2011))
    companyList.add(Company("C3", "Industry", startYear = 1993, endYear = 2020))
    companyList.add(Company("C4", "Auto", startYear = 2001, endYear = 2021))
    companyList.add(Company("C5", "Hotel", startYear = 2001, endYear = 2020))
    companyList.add(Company("C6", "Technology", startYear = 2005, endYear = 2015))
    companyList.add(Company("C7", "Finance", startYear = 1996, endYear = 2014))
    companyList.add(Company("C8", "Finance", startYear = 1980, endYear = 2007))
    companyList.add(Company("C9", "Auto", startYear = 1985, endYear = 2008))
    companyList.add(Company("C10", "Hotel", startYear = 1989, endYear = 2004))

    // print Company List using For Loop
    println("------------------------------- printListUsingForLoop ---------------------------")
    printListUsingForLoop(companyList)

    // print Company List using For Each Loop
    println("------------------------------- printListUsingForEachLoop ---------------------------")
    printListUsingForEachLoop(companyList)

    /**
     * Filter : Remember Filter gives us a New List. (I mean the same List should not be manipulated/altered)
     */
    // Filter Using Loop
    filterUsingLoop(companyList)

    // Filter Using Filter Predicate
    filterUsingFilterPredicate(companyList)
}

fun printListUsingForLoop(list: MutableList<Company>) {

    for (i in 0 until list.size) {
        println(list[i])
    }
    print("\n")
}

fun printListUsingForEachLoop(list: MutableList<Company>) {

    /**
     * Approach :
     * This approach is Passing One Function inside Another Function(i.e Higher Order Function in Kotlin) (called as Lambda Function)
     * lambda functions are not declared but are passed immediately as an expression, So everything inside the {} is
     * function definition, and this function will be called by the parent function (Note the params of Lambda Function are already defined by parent function)
     *
     * Usage:
     *  It can be used for writing more Readable and Concise code
     */
    list.forEach {
        println(it)
    }

    print("\n")
}

fun filterUsingLoop(companyList: MutableList<Company>) {
    // Q1. Filter List of Technology Companies
    val technologyCompanyList = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.type == "Technology")
            technologyCompanyList.add(company)
    }

    // print the list
    println("------------------------------- Filter Technology Company List Using Loop ---------------------------")
    printListUsingForEachLoop(technologyCompanyList)

    // Q2. Filter List of Companies, which started after 1994 (i.e >1994)
    val companyAfter1994List = mutableListOf<Company>()

    // Add the filtered data to New List
    companyList.forEach { company ->
        if (company.startYear > 1994)
            companyAfter1994List.add(company)
    }

    // print the list
    println("------------------------------- Filter Company List After 1994 Using Loop ---------------------------")
    printListUsingForEachLoop(companyAfter1994List)

}

fun filterUsingFilterPredicate(companyList: MutableList<Company>) {
    // Q1. Filter List of Technology Companies
    val technologyCompanyList = companyList.filter { company ->
        company.type == "Technology"
    }
    // print the list
    println("------------------------------- Filter Technology Company List Filter Predicate ---------------------------")
    printListUsingForEachLoop(technologyCompanyList as MutableList<Company>)

    // Q2. Filter List of Companies, which started after 1994 (i.e >1994)
    // Add the filtered data to New List
    val companyAfter1994List = companyList.filter { company ->
        company.startYear > 1994
    }

    // print the list
    println("------------------------------- Filter Company List After 1994 Using Filter Predicate ---------------------------")
    printListUsingForEachLoop(companyAfter1994List as MutableList<Company>)
}
