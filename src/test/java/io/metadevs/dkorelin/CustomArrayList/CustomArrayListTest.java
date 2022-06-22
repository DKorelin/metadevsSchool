package io.metadevs.dkorelin.CustomArrayList;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    private final long seed = 0;

    @Test
    void Given_CustomArrayListFromTestArray_When_RemoveElementsAndCompareWithTestArray_Then_AllEqual() {
        int numberOfElements = 100;
        String[] testArray = simpleTestArray(numberOfElements);
        List<String> testList = new CustomArrayList<>(testArray);
        for (int i = 0; i < numberOfElements; i++) {
            assertEquals(testArray[i], testList.remove(0));
        }

    }

    @Test
    void Given_EmptyList_When_AddOneElement_Then_CustomArrayListRemovesFromItSuccessfully() {
        List<String> testList = new CustomArrayList<>(1);
        String testData = "testData";
        testList.add(testData);
        assertEquals(testData, testList.remove(0));
    }

    @Test
    void Given_EmptyList_When_AddNumberOfElement_Then_CustomArrayListRemovesFromItSuccessfully() {
        int numberOfElements = 100;
        String[] testArray = simpleTestArray(numberOfElements);
        List<String> testList = new CustomArrayList<>(1);
        for (int i = 0; i < numberOfElements; i++) {
            testList.add(testArray[i]);
        }
        for (int i = 0; i < numberOfElements; i++) {
            assertEquals(testArray[i], testList.remove(0));
        }
    }

    @Test
    void Given_EmptyList_When_Size_Then_EqualsZero() {
        List<String> testList = new CustomArrayList<>(1);
        assertEquals(testList.size(), 0);
    }

    @Test
    void Given_FilledList_When_Size_Then_SizeEqualsNumberOfAddedElements() {
        int numberOfElements = 100;
        String testData = "testData";
        List<String> testList = new CustomArrayList<>(1);
        for (int i = 0; i < numberOfElements; i++) {
            testList.add(testData);
        }
        assertEquals(testList.size(), numberOfElements);
    }

    @Test
    void Given_EmptyList_When_InvokedIsEmpty_Then_True() {
        List<String> testList = new CustomArrayList<>(1);
        assertTrue(testList.isEmpty());
    }

    @Test
    void Given_NonEmptyList_When_InvokedIsEmpty_Then_False() {
        List<String> testList = new CustomArrayList<>(1);
        String testData = "testData";
        testList.add(testData);
        assertFalse(testList.isEmpty());
    }

    @Test
    void Given_CustomArrayListFromArray_When_ContainsWithContainedData_Then_True() {
        int numberOfElements = 100;
        int targetNumber = new Random(seed).nextInt(numberOfElements);
        String[] testArray = simpleTestArray(numberOfElements);
        List<String> testList = new CustomArrayList<>(testArray);
        assertTrue(testList.contains(testArray[targetNumber]));
    }

    @Test
    void Given_CustomArrayListFromArray_When_ContainsWithNotContainedData_Then_False() {
        int numberOfElements = 100;
        String testData = "testData";
        String nonContainedData = testData + numberOfElements;
        String[] testArray = simpleTestArray(numberOfElements);
        List<String> testList = new CustomArrayList<>(testArray);
        assertFalse(testList.contains(nonContainedData));
    }

    @Test
    void Given_CustomArrayListFromArray_When_ConvertedViaToArray_Then_ArraysEqual() {
        int numberOfElements = 100;
        String[] testArray = simpleTestArray(numberOfElements);
        List<String> testList = new CustomArrayList<>(testArray);
        assertArrayEquals(testArray, testList.toArray());
    }

    @Test
    void Given_CustomArrayListFromArray_When_CreatedSublistAndConvertedToArray_Then_ArraysEqual() {
        int numberOfElements = 100;
        Random randomGen = new Random(seed);
        int fromIndex = randomGen.nextInt(numberOfElements);
        int toIndex = randomGen.nextInt(numberOfElements - fromIndex) + fromIndex;
        String[] testArray = simpleTestArray(numberOfElements);
        String[] goldenArray = simpleTestArray(toIndex - fromIndex,fromIndex);
        List<String> testList = new CustomArrayList<>(testArray);
        List<String> testSublist = testList.subList(fromIndex,toIndex);
        assertArrayEquals(goldenArray, testSublist.toArray());
    }

    private String[] simpleTestArray(int numberOfElements) {
        String testData = "testData";
        String[] testArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            testArray[i] = testData + i;
        }
        return testArray;
    }

    private String[] simpleTestArray(int numberOfElements, int offset) {
        String testData = "testData";
        String[] testArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            testArray[i] = testData + (i + offset);
        }
        return testArray;
    }
}