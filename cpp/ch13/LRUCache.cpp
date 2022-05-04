//
// Created by Suhail Kandanur on 2022-04-16.
//

#include <unordered_map>
#include <iostream>
#include <string>

struct LRUCacheNode;

struct LRUCacheNode {
    LRUCacheNode *prev, *next;
    int key;
    std::string value;

    LRUCacheNode(int key, const std::string &value) : key(key), value(value), prev(NULL), next(NULL) {}
};

struct LRUCache {
    int cacheSize;
    std::unordered_map<int, std::string> underlyingData;
    std::unordered_map<int, LRUCacheNode *> cache;
    LRUCacheNode *first;

    LRUCache(const std::unordered_map<int, std::string> &data, int cacheSize = 2) : underlyingData(data),
                                                                                    cacheSize(cacheSize) {
        first = NULL;
    }

    std::string get(int key) {
        auto found = cache.find(key);
        if (found != cache.cend() && found->second->key == key) {
            std::cout << "cache hit for key " << key << std::endl;
            // push the node to the first
            LRUCacheNode *entry = found->second;
            if (entry != first) {
                if(entry->prev != NULL) {
                    entry->prev->next = entry->next;
                }
                if(entry->next != NULL) {
                    entry->next->prev = entry->prev;
                }
                entry->next = first;
                first->prev = entry;
                entry->prev = NULL;
                first = entry;
            }
            return found->second->value;
        }
        std::cout << "cache miss for key " << key << std::endl;

        // element not found in cache, fetch from the underlying data source
        auto foundInData = underlyingData.find(key);
        if (foundInData != underlyingData.cend()) {
            LRUCacheNode *newEntry = new LRUCacheNode(foundInData->first, foundInData->second);
            newEntry->next = first;
            if(first != NULL) {
                first->prev = newEntry;
            }
            first = newEntry;
            cache.insert(std::make_pair(key, newEntry));
            // housekeeping, ensure the number of elements in cache is less than cacheSize
            if (cache.size() > cacheSize) {
                std::cout << "cache size exceeded capacity (actual: " << cache.size() << ", max: " << cacheSize << ")"
                          << std::endl;
                LRUCacheNode *last = first;
                std::cout << "Finding last node - ";
                while (last->next != NULL) {
                    std::cout << last->key << " ";
                    last = last->next;
                }
                std::cout << ", last: " << last->key << std::endl;
                assert(last != NULL);
                // remove the least recently used entry
                cache.erase(last->key);
                LRUCacheNode *nodeBeforeLast = last->prev;
                if (nodeBeforeLast != NULL) {
                    nodeBeforeLast->next = NULL;
                }
                std::cout << "Deleted entry with key: " << last->key << std::endl;
                delete (last);
            }
            return newEntry->value;
        }
    }
};

int main(int argc, char *argv[]) {
    std::unordered_map<int, std::string> dict = {
            {1, "one"},
            {2, "two"},
            {3, "three"},
            {4, "four"}
    };
    LRUCache cache(dict, 2);
    std::cout << cache.get(1) << std::endl;
    std::cout << cache.get(2) << std::endl;
    std::cout << cache.get(3) << std::endl;
    std::cout << cache.get(4) << std::endl;
    std::cout << cache.get(1) << std::endl;
    std::cout << cache.get(4) << std::endl;
    std::cout << cache.get(2) << std::endl;
    std::cout << cache.get(1) << std::endl;
    std::cout << cache.get(1) << std::endl;
    return 0;
}