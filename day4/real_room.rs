use std::collections::BTreeMap;

fn main() {
    let input = include_str!("advoc_in_4.txt");
    let mut total = 0;
    let mut real_rooms = Vec::new();
    for line in input.lines() {
        let line = line.replace("-", "");
        let mut map = BTreeMap::new();
        let mut idx = 0;
        for c in line.chars() {
            if c.is_digit(10) {
                break;
            }
            idx += 1;
            *map.entry(c).or_insert(0) += 1;
        }
        let end = line.rfind("[").unwrap();
        let id = line[idx..end].parse::<u32>().unwrap();
        let checksum = &line[end + 1..line.len() - 1];
        let mut vec = map.into_iter().collect::<Vec<(_, _)>>();
        vec.sort_by_key(|&(x, _)| x);
        vec.sort_by_key(|&(_, y)| -y);
        let mut real_checksum = String::new();
        for &(c, _) in vec.iter().take(5) {
            real_checksum.push(c);
        }
        if checksum == real_checksum {
            total += id;
            real_rooms.push(((&line[..idx]).to_string(), id));
        }
    }
    println!("Part 1: {}", total);

    for (name, id) in real_rooms.into_iter() {
        let mut newname = String::new();
        for c in name.chars() {
            let mut i = c as u8 - 97;
            i = ((i as usize + id as usize) % 26) as u8;
            i += 97;
            newname.push( i as char);
        }
        if newname.contains("northpole") {
            println!("Part 2: Room name: {}, Room id: {}", newname, id);
        }
    }
}
