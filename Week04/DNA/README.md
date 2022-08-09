https://coding-competitions-staging.appspot.com/codejam/round/0000000000a563a6/0000000000a58451 <br>
<h2> DNA </h2>
DNA, the carrier of genetic information in living things, has been used in criminal justice for decades. But how, exactly, does DNA profiling work? Given a sequence of DNA, how can forensic investigators identify to whom it belongs? <br>

Well, DNA is really just a sequence of molecules called nucleotides, arranged into a particular shape (a double helix). Each nucleotide of DNA contains one of four different bases: adenine (A), cytosine (C), guanine (G), or thymine (T). Every human cell has billions of these nucleotides arranged in sequence. Some portions of this sequence (i.e. genome) are the same, or at least very similar, across almost all humans, but other portions of the sequence have a higher genetic diversity and thus vary more across the population. <br>

One place where DNA tends to have high genetic diversity is in Short Tandem Repeats (STRs). An STR is a short sequence of DNA bases that tends to be repeated back-to-back numerous times at specific locations in DNA. The number of times any particular STR repeats varies a lot among different people. In the DNA samples below, for example, Alice has the STR AGAT repeated four times in her DNA, while Bob has the same STR repeated five times. <br>

Alice: CTAGATAGATAGATAGATGACTA. <br>

Bob: CTAGATAGATAGATAGATAGATT. <br>

Using multiple STRs, rather than just one, can improve the accuracy of DNA profiling. If the probability that two people have the same number of repeats for a single STR is 5%, and the analyst looks at 10 different STRs, then the probability that two DNA samples match purely by chance is about 1 in 1 quadrillion (assuming all STRs are independent of each other). So if two DNA samples match in the number of repeats for each of the STRs, the analyst can be pretty confident they came from the same person. CODIS, The FBI's DNA database, uses 20 different STRs as part of its DNA profiling process. <br>

Consider the following database, containing the information about 3 STRs for two people: <br>
> 3 AGAT AATG TATC <br>
> 2 <br>
> Alice 28 42 14 <br>
> Bob 17 22 19 <br>
<br>
This database encodes that supported STRs are AGAT, AATG and TATC; and that Alice has the sequence AGAT repeated 28 times consecutively somewhere in her DNA, the sequence AATG repeated 42 times, and TATC repeated 14 times. Bob, meanwhile, has those same three STRs repeated 17 times, 22 times, and 19 times, respectively. <br>
So given a sequence of DNA, how might you identify to whom it belongs? Well, imagine that you looked through the DNA sequence for the longest consecutive sequence of repeated AGATs and found that the longest sequence was 17 repeats long. If you then found that the longest sequence of AATGs is 22 repeats long, and the longest sequence of TATC is 19 repeats long, that would provide pretty good evidence that the DNA was Bob's. Of course, it's also possible that once you take the counts for each of the STRs, it doesn't match anyone in your DNA database, in which case you have no match. <br>

Your task is to write a program that will take a DNA database with STR counts for a list of individuals, a list of DNAs, and then output to whom the DNAs (most likely) belong.

Source: http://nifty.stanford.edu/2020/dna/.

<h2> Input </h2>
The first line of the input contains S: the number of STRs, followed by the STRs themselves. Each STR is a string containing capital latin letters A, C, G, or T. <br>

The next line contains N: the number of people in the database. <br>

The next N lines contain the information about every person: their name, and the number of times the corresponding STR is replicated in their DNA. <br>

The next line contains M: the number of samples to identify. <br>

The following M lines are test cases: strings containing capital latin letters A, C, G, or T. <br>

<h2> Output </h2>
For each sample, output one line containing Case #x: y, where x is the sample number (starting from 1), and y is either the name of the person, to whom the sample belongs, or string No match if such person does not exist in the database.

