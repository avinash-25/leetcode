var join = function(arr1, arr2) {
    const map = new Map();

    // Insert all elements from arr1
    for (const obj of arr1) {
        map.set(obj.id, { ...obj });
    }

    // Merge or override with arr2
    for (const obj of arr2) {
        if (map.has(obj.id)) {
            map.set(obj.id, { ...map.get(obj.id), ...obj }); // merge with arr2 overriding
        } else {
            map.set(obj.id, { ...obj });
        }
    }

    // Convert map to array and sort by id
    return Array.from(map.values()).sort((a, b) => a.id - b.id);
};
