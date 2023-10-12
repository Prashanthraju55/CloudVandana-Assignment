function reverseWords(sentences) {
  let words = sentences.split(" ");
  let reversedWords = words.map((word) => word.split("").reverse().join(""));
  return reversedWords.join(" ");
}
function sortArray(arraynumbers) {
  arraynumbers.sort((a, b) => b - a);
  return arraynumbers;
}
let sentence = "This is a sunny day";
let reversedSentence = reverseWords(sentence);
console.log(reversedSentence);
let arraynumbers = [5, 3, 2, 1, 4];
let sortedArray = sortArray(arraynumbers);
console.log(sortedArray);