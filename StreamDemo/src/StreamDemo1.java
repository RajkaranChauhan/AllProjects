import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {
	public static void main(String[] args) {
		findDuplicate();
		reverseStringAndSaveTheSpace();
		distValuesFromArrayList();
		highestLengthWordInString();
		secondHighestLengthWordInString();
		secondHighestLengthInString();
		removeDuplicateFromStringAndSameOrder();
		occurrenceOfEachWord();
		exactlyTwoVowelsInString();
		separateEvenOddList();
		occurrenceOfCharInWord();
		arrangeNumInDesc();
		sumOfUniqueNumber();
		findFirstNonRepetitiveCharOfString();
		findFirstRepetitiveCharOfString();
		groupTheNumberByTheRange();
		getIntegerValueFromList();
		sumOfFirstTwoDigitOfArr();

		pairAnagramsFromString();
		multiplyAlternativeNumber();
		multiplyFirstAndLastSecondAndSecondLastAndSoOn();
		moveZeroToBeginningOfArray();
		arrayContainsDistinctValues();
		groupStringBasedOnMiddleChar();
		sumOfElement();

		sortListOfStingAlphabeticOrder();
		convertListOfIntegerToListOfSquare();
		distinctOddNumbers();
		unionOfTwoListInteger();
		intersectionOfTwoList();
		findKThSmallestIntegerInList();
		removeNonNumericCharacters();
		findStringContainingOnlyDigit();
		averageOfNumbers();
		groupListWithFirstCharAndCountNumberOfString();
		multiplyArrayElement();
		forGivenArrayConvertToUpperAndSingleString();
		findMaxNumber();
		iterator();
		reduce();
		printDistNumInDescOrderStartsWithOne();
		countOfParticularSubString();
		returnCharWithMaxFrequency();
		convertListOfStringToMapAndGetLength();

	}
	public static void findDuplicate(){
		String str = "raj karan chauhan laxmi chauhan";
		List<String> collect = Arrays.stream(str.split(" ")).collect(Collectors.toList());
		List<String> collect1 = collect.stream().filter(x -> Collections.frequency(collect, x) == 1).collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect1);
	}
	public static void reverseStringAndSaveTheSpace(){
		System.out.println("reverseStringAndSaveTheSpace");
		String name="Raj karan chauhan";
		String collect = IntStream.range(0, name.length())
				.mapToObj(x -> name.charAt(name.length() - 1 - x))
				.map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println(collect);

	}
	public static void convertListOfStringToMapAndGetLength(){
		System.out.println("convertListOfStringToMapAndGetLength");
		List<String > fruits= Arrays.asList("Apple", "banana", "Kiwi");

		Map<String, Integer> collect = fruits.stream().collect(Collectors.toMap(
				x->x.toLowerCase(),
				String::length
		));
		System.out.println(collect);


	}
	public static void returnCharWithMaxFrequency(){
		System.out.println("returnCharWithMaxFrequency");
		String s= "javaDevelopers";

		Map<String, Long> collect = Arrays.stream(s.split("")).map(x -> x.toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);


		String s1 = collect.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.get();
		System.out.println(s1);
//		OptionalInt max = collect.entrySet().stream().map(x -> x.getValue()).map(Long::intValue).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).max();
//		System.out.println(max);


	}
	public static void countOfParticularSubString(){
		System.out.println("countOfParticularSubString");
		String s="byebyeBirdbye";
		String check="bye";

		long count = IntStream.range(0, s.length() - 2) /// check is 3 length so 3-1=2 , 2 is minus
				.filter(x -> s.substring(x, x + 3).equalsIgnoreCase(check))
				.count();
		System.out.println(count);

	}
	public static void printDistNumInDescOrderStartsWithOne(){
		System.out.println("printDistNumInDescOrderStartsWithOne");
		int[] arr={12,34,11,35,67,121,121,114,78};
		List<Integer> collect = Arrays.stream(arr)
				.mapToObj(x -> x)
				.filter(y -> String.valueOf(y).startsWith("1"))
				.sorted(Collections.reverseOrder())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void reduce(){
		System.out.println("\nreduce");
		int[] arr= {1,2,3,4};
		int reduce = Arrays.stream(arr).reduce((a, b) -> a + b).getAsInt();
		System.out.println(reduce);
		System.out.println("-------second method");
		int reduce1 = Arrays.stream(arr).reduce(0, Integer::sum);
		System.out.println(reduce1);
	}
	public static void iterator(){
		System.out.println("iterator");
		Stream.iterate(0,x->x+5).limit(5).forEach(System.out::print);
	}
	public static void findMaxNumber(){
		System.out.println("findMaxNumber");
		int[] arr= {1,2,5,3,6,7,4};
		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println(max);
		Integer max1 = Arrays.stream(arr).boxed().max(Integer::compareTo).get();
		System.out.println("--- Second way");
		List<Integer> num=Arrays.asList(1,2,5,3,6,7,4);
//		Integer i = num.stream().max(Integer::compareTo).get();
		Integer i = num.stream().max((a,b)->a.compareTo(b)).get();
		System.out.println(i);
	}
	public static void forGivenArrayConvertToUpperAndSingleString(){
		System.out.println("forGivenArrayConvertToUpperAndSingleString");
		List<String> str= Arrays.asList("a","b","c","d");
		String s = str.stream().map(x -> x.toUpperCase()).reduce((a, b) -> a + " " + b).get();
		System.out.println(s);
		System.out.println("----second method");
		String r = str.stream().map(String::toUpperCase).reduce((a, b) -> a + "" + b).get();
		System.out.println(r);

	}
	public static void multiplyArrayElement(){
		System.out.println("multiplyArrayElement");
		Integer[] arr= {1,2,3,4,5};
		Integer i = Arrays.stream(arr).reduce((a, b) -> a * b).get();
		System.out.println(i);
	}
	public static void groupListWithFirstCharAndCountNumberOfString(){
		System.out.println("groupListWithFirstCharAndCountNumberOfString");
		List<String> arr= Arrays.asList("apple","banana","cherry","aeroplane","boll","animal");
		Map<String, Long> collect = arr.stream().collect(Collectors.groupingBy(x -> Arrays.stream(x.split("")).limit(1).findFirst().get(), Collectors.counting()));
		System.out.println(collect);
		System.out.println("----Second method");
		Map<Character, Long> collect1 = arr.stream().collect(Collectors.groupingBy(x -> x.charAt(0), Collectors.counting()));
		System.out.println(collect1);

	}
	public static void intersectionOfTwoList(){
		System.out.println("intersectionOfTwoList");
		List<Integer> lst1= Arrays.asList(1,2,3,4,5);
		List<Integer> lst2= Arrays.asList(6,7,8,1,2);
		List<Integer> collect = lst1.stream().filter(lst2::contains).collect(Collectors.toList());
		System.out.println(collect);

	}
	public static void averageOfNumbers(){
		System.out.println("averageOfNumbers");
		List<Integer> lst= Arrays.asList(1,2,3,4,5);
		Double average = lst.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(average);
	}
	public static void findStringContainingOnlyDigit(){
		System.out.println("findStringContainingOnlyDigit");
		List<String> arr= Arrays.asList("123","abc","123abc","45");
// her we use match for regular expression and contains is used for literal sub string and + is used for one or more then one digits
		List<String> collect = arr.stream().filter(x -> x.matches("[0-9]+")).collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void removeNonNumericCharacters(){
		System.out.println("removeNonNumericCharacters");
		List<String> arr= Arrays.asList("a1b2c3","4d5e6f","7r8t9y");
		List<String> collect = arr.stream().map(x -> x.replaceAll("[^0-9]", "")).collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void findKThSmallestIntegerInList(){
		System.out.println("findKThSmallestIntegerInList");
		List<Integer> lst1= Arrays.asList(1,1,2,2,3,4,5);
		int k=4;
		Integer i = lst1.stream().sorted().limit(k).skip(k - 1).findFirst().get();
		System.out.println(i);
	}
	public static void unionOfTwoListInteger(){
		System.out.println("unionOfTwoListInteger");
		List<Integer> lst1= Arrays.asList(1,2,3,4,5);
		List<Integer> lst2= Arrays.asList(6,7,8,9,10);
		List<Integer> collect = Stream.concat(lst1.stream(), lst2.stream()).collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void distinctOddNumbers(){
		System.out.println("distinctOddNumbers");
		List<Integer> lst= Arrays.asList(1,2,3,4,5,6,7,8,9,1,3);
		List<Integer> collect = lst.stream().filter(x -> x % 2 != 0).distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void convertListOfIntegerToListOfSquare(){
		System.out.println("convertListOfIntegerToListOfSquare");
		List<Integer> lst= Arrays.asList(1,2,3,4,5);
		List<Integer> collect = lst.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void sortListOfStingAlphabeticOrder(){
		System.out.println("sortListOfStingAlphabeticOrder");
		List<String > str= Arrays.asList("Zudio","Puma","Box","Man");
		List<String> collect = str.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect);

	}
	public static void distValuesFromArrayList() {
		System.out.println("distValuesFromArrayList");
		String name= "raj karan chauhan laxmi chauhan karan chauhan";
		String[] split = name.split(" ");
		List<String> asList = Arrays.asList(split);
		List<String> collect = asList.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void highestLengthWordInString(){
		System.out.println("highestLengthWordInString");
		String name= "raj karan chauhan laxmi chauhan karan chauhan";
		String s = Arrays.stream(name.split(" ")).max(Comparator.comparing(String::length)).orElse("please provide words to compare");
		System.out.println(s);
	}
	public static void removeDuplicateFromStringAndSameOrder(){
		System.out.println("removeDuplicateFromStringAndSameOrder");
		String name="chauhan";
		name.chars().distinct().mapToObj(x->(char)x).forEach(System.out :: print);
		System.out.println(" ");
		System.out.println("method 2:");
		Arrays.stream(name.split("")).distinct().forEach(System.out::print);
	}
	public static void secondHighestLengthWordInString(){
		System.out.println("secondHighestLengthWordInString");
		String name= "raj karan chauhan laxmi chauhan karan chauhan";
		String s = Arrays.stream(name.split(" ")).distinct().sorted(Comparator.comparing(String::length).reversed())
				.skip(1)
				.findFirst()
				.orElse("please provides words");
		System.out.println(s);
	}
	public static void secondHighestLengthInString(){
		System.out.println("secondHighestLengthInString");
		String name= "raj karan chauhan";
		int i=Arrays.stream(name.split(" ")).map(x-> x.length())
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		System.out.println(i);
	}
	public static void occurrenceOfEachWord(){
		System.out.println("occurrenceOfEachWord");
		String name ="raj karan chauhan laxmi chauhan";
//		Map<String, Long> collect = Arrays.stream(name.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<String, Long> collect = Arrays.stream(name.split(" ")).collect(Collectors.groupingBy(x->x, Collectors.counting()));
		System.out.println(collect);
	}
	public static void exactlyTwoVowelsInString(){
		System.out.println("exactlyTwoVowelsInString");
		String name= "raj karan chauhan laxmi chauhan karan chauhan";
		Arrays.stream(name.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2)
				.forEach(System.out :: println);

	}
	public static void separateEvenOddList(){
		System.out.println("separateEvenOddList");
		int a[]= {1,2,3,4,5,6,7,8,9};
		List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> even = collect.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println("printing even numbers using filter : "+even);
		List<Integer> odd = collect.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
		System.out.println("printing even numbers using filter : "+odd);

		Map<Boolean, List<Integer>> map = collect.stream().collect(Collectors.groupingBy(x -> x % 2 == 0));
		System.out.println("->"+map);
		List<List<Integer>> collected = collect.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
				.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());

		System.out.println("using collectCollectorsGroupingBy : "+ collected);
		List<Integer> collect1 = collected.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(collect1);


	}
	public static void occurrenceOfCharInWord(){
		System.out.println("occurrenceOfCharInWord");
		String s= "mississippi";
		Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(x->x, Collectors.counting()));
		System.out.println(collect);
	}
	public static void arrangeNumInDesc(){
		System.out.println("arrangeNumInDesc");
		int[] num={1,2,3,4,5};
		Arrays.stream(num).boxed().sorted().forEach(System.out::print);
		System.out.println("\n");
		Arrays.stream(num).boxed().sorted(Collections.reverseOrder()).forEach(System.out::print);
	}
	public static void sumOfUniqueNumber(){
		System.out.println("\n sumOfUniqueNumber");
		int[] num={1,1,2,3,4,5,5,6,7,8,9,9};
//		Stream<Integer> distinct = Arrays.stream(num).boxed().distinct().sum();
//		here the sum() methods are only available for primitive values int not for Integers. boxed() converts an IntStream (of primitive int values) to a Stream<Integer> (which is an object wrapper of int).
		int distinct = Arrays.stream(num).distinct().sum();
		System.out.println(distinct);
	}
	public static void findFirstNonRepetitiveCharOfString(){
		System.out.println("findFirstNonRepetitiveCharOfString");
		String str="hello worldh";
		String s = Arrays.stream(str.split("")).filter(c -> str.indexOf(c) == str.lastIndexOf(c))
				.findFirst()
//				.orElse("please provide string");
				.get();
		System.out.println(s);
		System.out.println("---second method");
//		List<Character> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		List<String> collect = Arrays.stream(str.split("")).collect(Collectors.toList());
		System.out.println(collect);

		LinkedHashMap<Character, Long> collect1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(collect1);
		Character c = collect1.entrySet().stream().filter(x -> x.getValue() == 1).map(y -> y.getKey()).findFirst().get();
		System.out.println(c);
	}
	public static void findFirstRepetitiveCharOfString(){
		System.out.println("findFirstRepetitiveCharOfString");
		String str="Hello world";
		LinkedHashMap<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(collect);
		Character c = collect.entrySet().stream().filter(x -> x.getValue() > 1).map(y -> y.getKey()).findFirst().get();
		System.out.println(c);
	}
	public static void groupTheNumberByTheRange(){
		System.out.println("groupTheNumberByTheRange");
		int[] arr={1,2,13,17,25,26,37};
		List<Integer> collect = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.toList());
		System.out.println(collect);
		Map<Integer, List<Integer>> collect1 = collect.stream().collect(Collectors.groupingBy(y -> (y / 10) * 10,LinkedHashMap::new, Collectors.toList()));
		System.out.println(collect1);
	}
	public static void getIntegerValueFromList(){
		System.out.println("getIntegerValueFromList");
		String[] arr={"abc","123","xyz","007"};
		List<Integer> numArr = Arrays.stream(arr).filter(x -> x.matches("[0-9]+")).map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(numArr);
		List<String> numArr1 = Arrays.stream(arr).filter(x -> x.matches("[0-9]+")).collect(Collectors.toList());
		System.out.println(numArr1);
	}
	public static void sumOfFirstTwoDigitOfArr(){
		System.out.println("sumOfFirstTwoDigitOfArr");
		int[] arr={5,6,1,2,3};
		List<Integer> collect = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.toList());
		System.out.println(collect);
		Integer reduce = collect.stream().limit(2).reduce(1, (x, y) -> x * y);
		System.out.println(reduce);
	}
	public static void pairAnagramsFromString(){
		System.out.println("pairAnagramsFromString");
				String[] arr= {"pat","tap","pan","nap","team","meat","tree"};
//		Arrays.stream(arr).mapToObj()  ==error
//		mapToObj() works only on primitive streams (IntStream, LongStream, DoubleStream), not on object streams.//
//				It converts elements of a primitive stream (like int, long, double) into objects.
		Map<List<String>, List<String>> collect = Arrays.stream(arr).collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().collect(Collectors.toList())));
		System.out.println(collect);

	}
	public static void multiplyAlternativeNumber(){
		System.out.println("multiplyAlternativeNumber");
		int[] arr={4,5,1,7,2,9,2};
		int reduce = IntStream.range(0, arr.length).filter(x -> x % 2 == 0).mapToObj(x->arr[x]).reduce(1, (a, b) -> a * b);
		System.out.println(reduce);
	}
	public static void multiplyFirstAndLastSecondAndSecondLastAndSoOn(){
		System.out.println("multiplyFirstAndLastSecondAndSecondLastAndSoOn");
		int[] arr={4,5,1,7,2,9,2};
		List<Integer> collect = IntStream.range(0, arr.length / 2).map(x -> arr[x] * arr[arr.length - 1 - x]).boxed().collect(Collectors.toList());
		System.out.println(collect);
	}
	public static void moveZeroToBeginningOfArray(){
		System.out.println("moveZeroToBeginningOfArray");
		int arr[]= {5,0,1,0,11,5,0};

		List<Integer> Zero = Arrays.stream(arr).mapToObj(x -> x).filter(y -> y == 0).collect(Collectors.toList());
		System.out.println(Zero);
		List<Integer> NonZero = Arrays.stream(arr).mapToObj(x -> x).filter(y -> y != 0).collect(Collectors.toList());
		System.out.println(NonZero);
		List<Integer> finalResult= new ArrayList<>();
		finalResult.addAll(Zero);
		finalResult.addAll(NonZero);
		System.out.println(finalResult);
		System.out.println("---Second Method");
		Map<Boolean, List<Integer>> map = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.partitioningBy(y -> y != 0));
		System.out.println(map);
		List<List<Integer>> collected = map.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
		System.out.println(collected);
		List<Integer> collect = collected.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(collect);

	}
	public static void arrayContainsDistinctValues(){
		System.out.println("arrayContainsDistinctValues");
		int[] arr={5,1,0,8,9,0};
		Map<Integer, Long> collect = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(collect);
		Collection<Long> values = collect.values();
		System.out.println(values);
		boolean b = values.stream().noneMatch(x -> x > 1);
		System.out.println(b);

		System.out.println("----Second method");
		System.out.println(collect);
		List<Map.Entry<Integer, Long>> collect1 = collect.entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toList());
		System.out.println(collect1);
		boolean b1 = collect1.size() >= 1;
		if (b1)
			System.out.println("The array contains duplicate");
		else
			System.out.println("the array does not contain duplicate");
	}
	public static void groupStringBasedOnMiddleChar(){
		System.out.println("groupStringBasedOnMiddleChar");
		String[] str ={"ewe","jij","kik","awe","aabcde"};
		Map<String, List<String>> collect = Arrays.stream(str).collect(Collectors.groupingBy(x -> x.substring(x.length()/2,(x.length()/2)+1)));   //substring(1, 2)
		System.out.println(collect);

	}
	public static void sumOfElement(){
		System.out.println("sumOfElement");
			System.out.println("sumOfElement");
			int [] arr= {1,2,3,4,5};
			int sum = Arrays.stream(arr).sum();
			System.out.println(sum);

		System.out.println("-----second method");

		List<Integer> num= Arrays.asList(1,2,3,4,5);
		int sum1 = num.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum1);


	}

/*
1. stream()
2. filter()
3. map()
4. flatmap()
5. forEach()
6.collect()
7. sorted()
8. limit()
9. distinct()
10. skip()
11. peek()
12. count()-- count the number of elements in the stream
	long count=names.stream().count();
13. allMatch()- all condition to be true
	boolean namesWithA =names.stream().allMatch(x->x.startsWith("A"));
14. anyMatch() - any condition to be true
	boolean namesWithA =names.stream().anyMatch(x->x.startsWith("A"));
15. noneMatch()- no matching condition
	boolean namesWithA =names.stream().noneMatch(x->x.startsWith("A"));
16.findFirst() - find the first element and return
	String name= nameList.stream().findFirst().get();
17. findAny()- returns any element of stream
	String anuName= nameList.findAny().get();
18. max()
	it should be performed in premetive type int
	numList.stream.max();
	Or for Integer type
	numList.stream().max(Integer::compareTo).get();
19. min()
20. toArray() -- convert the stream to Array
	String[] namesArray= nameList.stream().toArray(String[]::new);
21. iterate() -- creates infinite number of stream by itration over a funcion
	Stream<Integer> num= Stream.iterate(0, n->n+7).limit(5)
	num.forEach(System.out::Println);
	output: 0 7 14 21 28
22. of() -- created a stream from a set of values
	Stream<String> stream=Stream.of("A","B")
	stream.forEach(System.out::print);
	output: A B
23. concat()
	Stream.concat(list1,list2).collect(Collectors.toList());
24. reduce()- it reduces the element to a single value
	int[] arr= {1,2,3,4};
	int sum=arr.stream(arr).reduce(0,(a,b)->a+b);
	output" 10
25. InStream- NEED TO WORK ON IT
 */


}
