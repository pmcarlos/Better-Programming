## Simple program to find gene in a DNA

### Introduction

A gene is a sequence of DNA that contains three letter words knowns as codons. These words that form the codons are made out of a combination of 4 letters: A -> Adenine; T -> Thymine; C -> Cystosine; G -> Guanine.

Every gene is consisted with a start codon which is ATG and three end codons, TAA, TAG, and AGT.

### What this program does

It takes a DNA sequence and look for the beginning of a gene by find the start codon (ATG)'s position, then find one of the three stop codons' position. It subtracts the difference from stop codon and start codon's position. If the difference is multiple by 3, it returns the gene: all the sequence between the start codon (including) and the end codon (including). 
