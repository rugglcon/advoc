#[macro_use]
extern crate lazy_static;
extern crate regex;

use regex::Regex;

lazy_static! {
    static ref RE :Regex = Regex::new(r"(\w+)([\[\w+\]\w+]+)").unwrap();
    static ref RE2: Regex = Regex::new(r"\[(\w+)\](\w+)([\[\w+\]\w+]*)").unwrap();
}

fn has_abba(s: &str) -> bool {
    let v = s.chars().collect::<Vec<char>>();
    for window in v.windows(4) {
        if window[0] == window[3] && window[1] == window[2] && window[0] != window[1] {
            return true;
        }
    }
    return false;
}

fn find_abas(s: &str) -> Vec<(char, char, char)> {
    let mut vec = Vec::new();
    let v = s.chars().collect::<Vec<char>>();
    for window in v.windows(3) {
        if window[0] == window[2] && window[0] != window[1] {
            vec.push((window[0], window[1], window[2]));
        }
    }
    return vec;
}

fn tsl_compliant(line: &str) -> bool {
    let mut has_free_abba = false;
    let mut has_closed_abba = false;
    let cap = RE.captures(line).unwrap();
    let start = cap.at(1).unwrap();
    if has_abba(start) {
        has_free_abba = true;
    }
    let mut rest = cap.at(2).unwrap();
    while !rest.is_empty() {
        let cap = RE2.captures(rest).unwrap();
        let brackets = cap.at(1).unwrap();
        let non_brackets = cap.at(2).unwrap();
        rest = cap.at(3).unwrap();
        if has_abba(brackets) {
            has_closed_abba = true;
        }
        if has_abba(non_brackets) {
            has_free_abba = true;
        }
    }
    return has_free_abba && !has_closed_abba;
}

fn ssl_compliant(line: &str) -> bool {
    let mut aba_vec = Vec::new();
    let mut bab_vec = Vec::new();
    let cap = RE.captures(line).unwrap();
    let start = cap.at(1).unwrap();
    aba_vec.append(&mut find_abas(start));
    let mut rest = cap.at(2).unwrap();
    while !rest.is_empty() {
        let cap = RE2.captures(rest).unwrap();
        let brackets = cap.at(1).unwrap();
        let non_brackets = cap.at(2).unwrap();
        rest = cap.at(3).unwrap();
        aba_vec.append(&mut find_abas(non_brackets));
        bab_vec.append(&mut find_abas(brackets));
    }
    for aba in aba_vec.iter() {
        for bab in bab_vec.iter() {
            if aba.0 == bab.1 && aba.1 == bab.0 {
                return true;
            }
        }
    }
    return false;
}

fn main() {
    let input = include_str!("./in_7.txt");
    let mut tls_counter = 0;
    let mut ssl_counter = 0;
    for line in input.lines() {
        if tsl_compliant(line) {
            tls_counter += 1;
        }
        if ssl_compliant(line) {
            ssl_counter += 1;
        }
    }
    println!("Part 1: {}", tls_counter);
    println!("Part 2: {}", ssl_counter);
}
