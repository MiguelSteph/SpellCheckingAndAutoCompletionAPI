# Spell Checking And Auto Completion REST API
In this project. I have implemented a REST API for the spell cheking and for word auto completion. 
This repository is created by Stephane Miguel. For any suggestion or questions, please feel free to contact me at Skakanakou@gmail.com

# Implementation Details
## Data
In this project, I have used a text file that contains **479k English words**. Here is the link to the github repository that contains the data [**english-words**](https://github.com/dwyl/english-words). I have used the alphabetical version [**words_alpha.txt**](https://github.com/dwyl/english-words/blob/master/words_alpha.txt)

## Data Structure
I have implemented **26-Way Trie** to store efficiently the words and also to retrieve them efficiently. Here is the link to my implementation [**26-Way Trie**](https://github.com/MiguelSteph/SpellCheckingAndAutoCompletionAPI/blob/master/SpellCheckingAndAutoCompletion/src/main/java/com/spell/dao/RWayTrie.java)

## REST API
For the REST API implementation, I have used **Jersey** and **Jackson** in order to provide **JSON** format response. 

# Endpoints of the REST API
The REST API has the following endpoints : 
## Spelling Checking
The URI is  : **/restapi/spellingCheck/{word}** <br>
This endpoint help to check whether a word is well spelled or not. When the given word is not well spelled, the response suggests 10 words.
The response is formated as follow : 

- when the query word is  "spelling" , the response is : 

```
{
  "queryString": "spelling",
  "wellSpelled": true,
  "suggestion": []
}
```

- when the query word is "algorithmm", the response is : 

```
{
  "queryString": "algorithmm",
  "wellSpelled": false,
  "suggestion": [
				    "algorithm",
				    "algorithmic",
				    "algorithmically",
				    "algorithms"
			    ]
}
```
## Word Auto Completion
The URI is : **/restapi/autoCompletion/{prefix}** <br>
Given a **prefix**, this endpoint return in alphabetical order at most 20 words that have the given prefix.
The response is formated as follow : 

- When the given prefix is "sort" , the response is :

```
{
  "prefix": "sort",
  "propositions": [
				    "sort",
				    "sortable",
				    "sortably",
				    "sortal",
				    "sortance",
				    "sortation",
				    "sorted",
				    "sorter",
				    "sorters",
				    "sortes",
				    "sorts",
				    "sortwith",
				    "sorty"
				  ]
}
```

## Longest Prefix Word
The URI is : **/restapi/longestPrefixWord/{queryString}** <br>
Given a **queryString**, this endpoint return the word that is the longest prefix of the given query sring.
The response is formated as follow : 

- When the given query string is "computationalblem" , the response is : 

```
{
  "queryString": "computationalblem",
  "longestPrefixWord": "computational"
}
```
